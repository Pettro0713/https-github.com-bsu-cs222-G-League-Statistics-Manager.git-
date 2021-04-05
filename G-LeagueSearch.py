import http.client
import json


file = open("playerid.txt","r")
Search= input('Enter Full Name:')
for block in str(file.read()).split('}'):
    if Search in block:
        player_id = block [11:47]
        print (player_id)
    else:
        print('player not found')
        exit()
file.close()

conn = http.client.HTTPSConnection("api.sportradar.us")
conn.request("GET", "/nbdl/trial/v7/en/players/"+player_id+"/profile.json?api_key=********************")

res = conn.getresponse()
read= res.read()
data = json.loads(read.decode("utf-8"))

for sentence in str(data).split(','):
    if "full_name" in sentence:
        PlayerName = sentence [15:len(sentence)-1]
        print(PlayerName)
    if "height" in sentence:
        PlayerHeight = sentence [11:len(sentence)]
        print(PlayerHeight)
    if "weight" in sentence:
        PlayerWeight= sentence [11:len(sentence)]
        print(PlayerWeight)
    if "jersey" in sentence:
        PlayerJersey= sentence [19:len(sentence)-1]
        print(PlayerJersey)
    if "college" in sentence:
        PlayerCollege = sentence [13:len(sentence)-1]
        print(PlayerCollege)
for season in str(data).split('}]'):
    if "2020" in season:
        for sentence in str(season).split(','):
            if "_" not in sentence:
                if "position" in sentence:
                    PlayerPosition = sentence [14:len(sentence) - 1]
                    print(PlayerPosition)
                if "." in sentence:
                    if "rebounds" in sentence:
                        PlayerRebounds= sentence [13:len(sentence)]
                        print(PlayerRebounds)
                    if "steals" in sentence:
                        PlayerSteals= sentence [11:len(sentence)]
                        print(PlayerSteals)
                    if "turnovers" in sentence:
                        PlayerTurnovers= sentence[14:len(sentence)]
                        print(PlayerTurnovers)
                    if "assists" in sentence:
                        PlayerAssists= sentence[12:len(sentence)]
                        print(PlayerAssists)
                    if "blocks" in sentence:
                        PlayerBlocks = sentence[11:len(sentence)]
                        print(PlayerBlocks)
                    if "points" in sentence:
                        PlayerPoints= sentence[11:len(sentence)]
                        print(PlayerPoints)