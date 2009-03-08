import domain.model
import simplejson
from google.appengine.ext import webapp, db
from google.appengine.api import users

class GameAction(webapp.RequestHandler):
    def post(self):
        user = users.get_current_user()
        if (user):
            query = domain.model.Player.all()
            query.filter("user =", user)
            player = query.fetch(1)[0]
            operation = self.request.get("op")
            if operation == "delete":
                games = domain.model.Game.all()
                games.filter("creator =", player)
                for game in games:
                    self.response.out.write("Deleted")    
                    game.delete()
        else:
            self.redirect(users.create_login_url(self.request.uri))

    def get(self):
        user = users.get_current_user()
        if (user):
            query = domain.model.Game.all()
            games = dict()
            x = 0
            for game in query:
                x = x + 1
                games[hash(x)] = {"name":game.name, 
                                  "creator":game.creator.alias,
                                  "id" : str(game.key()),
                                  "len" : game.playersConnected()
                                  }
            self.response.out.write(simplejson.dumps(games))
        else:
            self.redirect(users.create_login_url(self.request.uri))
        