# Kaj popraviti da bo delovalo ?
Absolutni pathi v :

Gui.java line 92 in 107

BuisnessLogic.java line 28

# Kako deluje ? 
Program, ko ga poženemo prikaže GUI s pomočjo katerega odpremo brskalnik za datoteke. Tam izberemo XML / JSON file, ki 
se sparsa, preračuna podake in zapiše v /resources/xml ali /resources/json. Shrani se glede na številko računa + končnica. 

Lahko pa tudi pridobimo datoteko. To naredimo tako, da v polje zapišemo številko računa in označimo katere vrste datoteka je. 
Če smo naredili vse pravilno se nam izpišejo podatki računa.
