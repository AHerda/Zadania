import java.lang.Math;

abstract class figura {
    enum Figury_1 implements obliczenia_1 {
        KOLO {
            public double LiczPole(double dana) {
                return dana * dana * Math.PI;
            }
            public double LiczObwod(double dana) {
                return 2 * Math.PI * dana;
            }
        },

        PIECIOKAT {
            public double LiczObwod (double dana) {
                return 5 * dana;
            }
            public double LiczPole (double dana) {
                return 0.25 * dana * dana * Math.sqrt(25 + 10 * Math.sqrt(5));
            }
        },

        SZESCIOKAT {
            public double LiczObwod (double dana) {
                return 6 * dana;
            }
            public double LiczPole (double dana) {
                return 0.25 * 6 * dana * dana * Math.sqrt(3);
            }
        },

        KWADRAT {
            public double LiczPole (double dana) {
                return dana * dana;
            }
            public double LiczObwod (double dana) {
                return dana * 4;
            }
        }
    }

    enum Figury_2 implements obliczenia_2 {
        ROMB {
            public double LiczObwod (double dana1, double dana2) {
                return dana1 * 4;
            }
            public double LiczPole (double dana1, double dana2) {
                return dana1 * dana1 * Math.sin(dana2);
            }
        },

        PROSTOKAT {
            public double LiczObwod (double dana1, double dana2) {
                return dana1 + dana1 + dana2 + dana2;
            }
            public double LiczPole (double dana1, double dana2) {
                return dana1 * dana2;
            }
        }
    }
}