#%%
import os

pathList = []

path = os.listdir(os.getcwd())
i = 0
for p in path:
    if os.path.isdir(p) == False and ".md" in p:
        print("{}: {}".format(i, p))
        pathList.append(p)
        i+=1

get = input("input the index:(-1==ALL)")

def deal(url):
    file = open(url)
    text = file.read()
    text = text.replace("/home/howin/Desktop/DimChat/Dimchat-Doc/img/Screen ", "https://raw.githubusercontent.com/How-invin/DimChat/master/Dimchat-Doc/img/Screen%20")
    file.close()
    file = open(url, 'w')
    file.write(text)

if(int(get) == -1):
  print("SELECT ALL")
  for p in pathList:
    print("tackle:{}".format(p))
    deal(p)
else:
  deal(pathList[int(get)])
# %%
