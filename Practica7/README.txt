Aquesta activitat s’ha de lliurar en grups de 2 persones. El lliurament es farà
exportant el projecte a un fitxer .zip Només cal un lliurament per cada grup.
Recorda que quan es demana una funció volem que retorni un valor i quan es
demana un procediment no volem que retorni cap valor.

1. Escriu una funció anomenada “CalcularDescompte” que, rebi com a
paràmetres el preu i la categoria d’un producte i retorni el preu amb el
descompte aplicat. Les categories poden ser de 3 tipus: A, B i C. Els productes
de categoria A tenen un 5% de descompte, els de categoria B un 10% de
descompte i els de categoria C tenen un 20% de descompte si el preu és
inferior a 100€ i de 35% si el preu és igual o superior a 100€.

2. Escriu una funció anomenada “CalcularIVA” a la que se li passa un preu, un
tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
d’IVA pot ser General, Reduït, Superreduït o Exempt. El percentatge a aplicar
és el vigent en la data de compra i el podem trobar en aquesta taula:
Data inici vigència General Reduït Superreduit Exempt
01-01-1986 12% 6% No existeix 0%
01-01-1992 15% 6% No existeix 0%
01-01-1993 15% 6% 3% 0%
01-01-1995 16% 7% 4% 0%
01-01-2010 18% 8% 4% 0%
15-07-2012 21% 10% 4% 0%

3. Escriu una funció anomenada “Roman” al que se li passa un número enter
entre 1 i 3999 i retorni el seu valor en números romans

4. Escriu una funció anomenada “ValidarSuperusuari” que demani un password
i que el comprovi amb un text emmagatzemat en una constant interna. Si no
coincideix l’ha de tornar a demanar un màxim de 3 vegades. La funció ha de
tornar si l’usuari ha encertat o no el password.

5. Escriu un procediment anomenat “Titol” que donat un text, el mostri per
pantalla de forma centrada. Pots assumir que la pantalla té un ample de 80
caràcters.

6. Implementa un programa que faci servir un tipus de dada anomenat “Pila”.
Una pila és un tipus de dada on es van afegint valors i es van traient en l’ordre
invers al qual s’han afegit, també conegut com LIFO (Last In First Out). El
programa ha de presentar el següent menú d’opcions:
1.- Afegir número (push)
2.- Treure número (pop)
3.- Mostrar contingut de la pila
M03 - Programació
UF2 – Programació modular
Activitat 7
Creat per Santi Rivas
Pàgina 2 de 2
4.- Sortir
La pila admet com a màxim 10 valors. Si intentem afegir un onzè element el
sistema no ho ha de permetre i ha d’avisar a l’usuari que la pila es troba plena.
De la mateixa manera, si intentem treure un número d’una pila que es troba
buida, també s’ha d’informar a l’usuari que no pot fer aquesta operació.
Al treure un número de la pila, s’ha de mostrar per pantalla quin és el número
que s’ha tret.
El programa s’ha d’implementar amb un array. No es poden fer servir els tipus
de dades de les llibreries de Java.
