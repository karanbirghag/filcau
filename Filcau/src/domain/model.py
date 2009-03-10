from google.appengine.ext import db
from google.appengine.api import users


class Player(db.Model):
    user = db.UserProperty()
    alias = db.StringProperty()

class Team(db.Model):
    name = db.StringProperty()
    player1 = db.ReferenceProperty(Player, collection_name="teams1")
    player2 = db.ReferenceProperty(Player, collection_name="teams2")

    def addPlayer(self, player):
        retValue = None
        if not self.player1:
            self.player1 = player
            retValue = 1
        elif not self.player2:
            self.player2 = player
            retValue = 2
        return retValue

    def removePlayer(self, player):
        if self.player1 and self.player1.alias == player.alias:
            self.player1 = None
        elif self.player2 and self.player2.alias == player.alias:
            self.player2 = None

    def getPlayer1Alias(self):
        if self.player1:
            return self.player1.alias
        else:
            return None

    def getPlayer2Alias(self):
        if self.player2:
            return self.player2.alias
        else:
            return None

class Game(db.Model):
    name = db.StringProperty()
    creator = db.ReferenceProperty(Player)
    players = db.ListProperty(str)
    team1 = db.ReferenceProperty(Team, collection_name="games1")
    team2 = db.ReferenceProperty(Team, collection_name="games2")

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
        