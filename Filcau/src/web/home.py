import os, domain.model
from google.appengine.ext import webapp
from google.appengine.api import users
from google.appengine.ext.webapp import template

class HomeAction(webapp.RequestHandler):
    def get(self):
        user = users.get_current_user()
        if (user):
            query = domain.model.Player.all()
            query.filter("user =", user)
            players = query.fetch(1)
            if players:
                player = players[0]
            else:
                player = domain.model.Player(user = user, alias = user.nickname())
                player.put();
            model = {'userName': user.nickname()
                     ,'logoutURL': users.create_logout_url('/')
                    }
            path = os.path.join(os.path.dirname(__file__), '../html/dashboard.html')
            self.response.out.write(template.render(path, model))
        else:
            self.redirect(users.create_login_url(self.request.uri))
