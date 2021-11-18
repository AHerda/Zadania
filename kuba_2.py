class Prostokat:
    def __init__(self, a=0, b=0):
        self.bok_a = a
        self.bok_b = b

    def pole(self):
        return self.bok_a*self.bok_b


class Kwadrat(Prostokat):
    def __init__(self, a=0):
        self.bok_a = a
        self.bok_b = a


p1 = Prostokat(5, 8)
p1_pole = p1.pole()
print(p1_pole)

p2 = Kwadrat(5)
p2_pole = p2.pole()
print(p2_pole)
