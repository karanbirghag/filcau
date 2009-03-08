from google.appengine.ext import db
from google.appengine.api import users

class Player(db.Model):
    user = db.UserProperty()
    alias = db.StringProperty()

class Team(db.Model):
    name = db.StringProperty()
    player1 = db.IntegerProperty()
    player2 = db.IntegerProperty()

class Game(db.Model):
    name = db.StringProperty()
    creator = db.ReferenceProperty(Player)
    players = db.ListProperty(str)
    team1 = Team(name='Team 1', player1=-1, player2=-1)
    team2 = Team(name='Team 2', player1=-1, player2=-1)

    def addPlayer(self, player):
        if len(self.players) < 4:
            self.players.append(str(player.key()))
    def remove(self, player):
        try:
            i = self.players.index(str(player.key()))
            del self.players[i]
        except ValueError:
            i = -1
        return i
    def playersConnected(self):
        return len(self.players)
    def joinTeam(self, player, teamNumber):
        team = self.team1
        if teamNumber == 2:
            team = self.team2
        try:
            i = self.players.index(str(player.key()))
        except ValueError:
            i = -1
        if team.player1 == -1:
            team.player1 = i
            return 1
        if team.player2 == -1:
            team.player2 = i
            return 2
        return -1
        
        