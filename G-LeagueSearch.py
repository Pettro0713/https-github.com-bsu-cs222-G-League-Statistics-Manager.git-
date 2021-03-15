import http.client



conn = http.client.HTTPSConnection("api.sportradar.us")

player_id= "46fdedca-bd0b-447d-af1d-06f016491d40"

conn.request("GET", "/nbdl/trial/v7/en/players/"+player_id+"/profile.json?api_key=f5gxhwerah7sn3sguu5ae5ea")

res = conn.getresponse()
data = res.read()

for sentence in str(data).split(','):
    if "full_name" in sentence:
        PlayerName = sentence
        print(PlayerName)
    if "height" in sentence:
        PlayerHeight = sentence
        print(PlayerHeight)
    if "weight" in sentence:
        PlayerWeight= sentence
        print(PlayerWeight)
    if "position" in sentence:
        PlayerPosition = sentence
        print(PlayerPosition)
    if "jersey" in sentence:
        PlayerJersey= sentence
        print(PlayerJersey)
    if "college" in sentence:
        PlayerCollege = sentence
        print(PlayerCollege)
    if "rebounds" in sentence:
        PlayerRebounds= sentence
        print(PlayerRebounds)
    if "steals" in sentence:
        PlayerSteals= sentence
        print(PlayerSteals)
    if '"turnovers"' in sentence:
        PlayerTurnovers= sentence
        print(PlayerTurnovers)
    if '"assists"' in sentence:
        PlayerAssists= sentence
        print(PlayerAssists)
    if '"blocks' in sentence:
        PlayerBlocks = sentence
        print(PlayerBlocks)
    if '"points"' in sentence:
        PlayerPoints= sentence
        print(PlayerPoints)




