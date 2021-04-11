fun main() {
    val list1 = "{=133672, frank=24, tzoar=5, segal=8, weiss=8, rothstein=2, hoffman=32, weidenfeld=1, ries=3, mermelstein=4, hurvitz=1, horwitz=4, gal=5, horovitz=2, white=4, falk=1, gurevich=3, gurewitz=14, berger=60, lipkin=4, erlich=1, levi=2, kaplan=105, keller=10, kershenbaum=4, greenbaum=20, averbuch=17, karp=40, soll=4, lewis=4, goodman=40, hurwitz=2, solomon=2, horowitz=5, markel=1, lando=1, goldberg=112}".split(", ")
    val list2 = "{=133672, hurwitz=2, horwitz=4, horowitz=5, gurevich=3, horovitz=2, rothstein=2, gurewitz=14, averbuch=17, kershenbaum=4, goldberg=112, levi=2, kaplan=105, goodman=40, mermelstein=4, greenbaum=20, keller=10, hoffman=32, gal=5, berger=60, segal=8, lipkin=4, weiss=8, karp=40, solomon=2, soll=4, frank=24, white=4, tzoar=5, lewis=4, ries=3}".split(", ")
    list1.forEach{
        if(it in list2) {}
        else println(it)
    }
}