import matplotlib.pyplot as plt

uchwyt = open("wyniki.txt")
n = uchwyt.read().split()[::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
Bn = uchwyt.read().split()[1::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
Un = uchwyt.read().split()[2::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
Ln = uchwyt.read().split()[3::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
Cn = uchwyt.read().split()[4::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
Dn = uchwyt.read().split()[5::7]
uchwyt.close()

uchwyt = open("wyniki.txt")
DCn = uchwyt.read().split()[6::7]
uchwyt.close()



print(n)