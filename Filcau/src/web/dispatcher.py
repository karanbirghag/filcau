import web.home, web.game, web.gameroom
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

app = webapp.WSGIApplication([
    ('/', web.home.HomeAction)
    ,('/g', web.gameroom.GameroomAction)
    ,('/game', web.game.GameAction)
 ], debug=False)

def main():
    run_wsgi_app(app)
if __name__ == "__main__":
    main()