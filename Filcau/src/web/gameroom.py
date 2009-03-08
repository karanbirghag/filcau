import os, domain.model
from google.appengine.ext import webapp, db
from google.appengine.api import users
from google.appengine.ext.webapp import template
import simplejson

class GameroomAction(webapp.RequestHandler):
    def get(self):
        user = users.get_current_user()
        if (user):
            query = domain.model.Player.all()
            query.filter("user =", user)
            players = query.fetch(1)
            if len(players):
                player = players[0]
            else:
                player = domain.model.Player(user = user, alias = user.nickname())
                player.put()
            
            op = self.request.get("op")
            if op == "joinTeam":
                self.joinTeam(player)
                return
            if op == "leave":
                game = db.get(db.Key(self.request.get("id")))
                if not game:
                    self.redirect("/")
                    return
                else:
                    code = game.remove(player)
                    game.put()
                    return
            if op == "check":
                game = db.get(db.Key(self.request.get("id")))
                if game:
                    players = []
                    for playerKey in game.players:
                        player = db.get(db.Key(playerKey))
                        players.append(player.alias)
                    self.response.out.write(simplejson.dumps(players))
                else:
                    self.response.out.write("Game ended")
                return
            
            if op == "join":
                game = db.get(db.Key(self.request.get("id")))
                if not game:
                    self.redirect(self.request.referer)
                    return
            else:
                game = domain.model.Game(name = self.request.get('gameName'), creator = player)
            game.addPlayer(player)
            game.put()
            
            connectedPlayers = []
            for key in game.players:
                player = db.get(db.Key(key))
                connectedPlayers.append(player)

            model = {'user': user
                     ,'logoutURL': users.create_logout_url('/')
                     ,'game' : game
                     ,'players' : connectedPlayers
                     ,'isOwner' : game.creator.user == user
                    }
            path = os.path.join(os.path.dirname(__file__), '../html/gameroom.html')
            self.response.out.write(template.render(path, model))
        else:
            self.redirect(users.create_login_url(self.request.uri))

    def post(self):
        self.get()
        
    def joinTeam(self, player):
        game = db.get(db.Key(self.request.get("id")))
        teamNumber = self.request.get("team")
        code = game.joinTeam(player, teamNumber)
        if not code == -1:
            game.put()
        self.response.out.write(code)
        return
        