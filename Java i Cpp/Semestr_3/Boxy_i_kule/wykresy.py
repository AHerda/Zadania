import matplotlib.pyplot as plt



def srednie(lista):
    srednia = [0]*100
    for i in range(100):
        suma = 0
        for j in range(50):
            suma += lista[i * 50 + j]
        srednia[i] = (suma/50)
    return srednia





uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
n_str = uchwyt.read().split()[::7]
uchwyt.close()

n = []
for i in range(len(n_str)):
    if(i == 0):
        n.append(int(n_str[i][-4:]))
    else:
        n.append(int(n_str[i]))

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Bn_str = uchwyt.read().split()[1::7]
uchwyt.close()

Bn = []
for i in Bn_str:
    Bn.append(int(i))

bn = srednie(Bn)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Un_str = uchwyt.read().split()[2::7]
uchwyt.close()

Un = []
for i in Un_str:
    Un.append(int(i))

un = srednie(Un)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Ln_str = uchwyt.read().split()[3::7]
uchwyt.close()

Ln = []
for i in Ln_str:
    Ln.append(int(i))

ln = srednie(Ln)

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Cn_str = uchwyt.read().split()[4::7]
uchwyt.close()

Cn = []
for i in Cn_str:
    Cn.append(int(i))

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
Dn_str = uchwyt.read().split()[5::7]
uchwyt.close()

Dn = []
for i in Dn_str:
    Dn.append(int(i))

uchwyt = open("wyniki.txt", encoding="UTF-16 LE")
DCn_str = uchwyt.read().split()[6::7]
uchwyt.close()

DCn = []
for i in DCn_str:
    DCn.append(int(i))


plt.figure(1)

plt.title("Wykres Bn")
plt.xlabel("Ilość urn")
plt.ylabel("Bn")

plt.plot(n, Bn, "bo", markersize=1)
plt.plot(range(1000, 100001, 1000), bn, "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Bn.png", dpi=300)

plt.figure(2)

plt.title("Wykres Un")
plt.xlabel("Ilość urn")
plt.ylabel("Un")

plt.plot(n, Un, "bo", markersize=1)
plt.plot(range(1000, 100001, 1000), srednie(Un), "ro-", markersize=1, linewidth=1)

plt.savefig("wykres Un.png", dpi=300)