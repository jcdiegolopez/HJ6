Universidad Del Valle De Guatemala   9 de marzo del 2024 Diego José López Campos 

Algoritmos y estructuras de datos 

**Hoja de trabajo 6** 

**REPO:[ https://github.com/jcdiegolopez/HJ6.git** ](https://github.com/jcdiegolopez/HJ6.git)**

**C.** 



|**Type  time in nanoseconds  time in miliseconds** |
| - |
|HASH   889148600  889.1486 |
|LINKED   558322500  558.3225 |
|TREE   540272800  540.2728 |

Para cada implementación de Map se puede concluir que el más rápido es el **treemap**, ya que tuvo la menor cantidad de delta tiempo en realizar la asignación e impresión de las cartas totales. 

**D.** 

HashMap R² = 0.6964![](images/Aspose.Words.4db93ba1-f4f7-4a06-9268-eb192b96ca04.001.png)

4000000 3500000 3000000

||||||
| :- | :- | :- | :- | :- |
||||||
||||||
||||||
||||||
||||||
||||||
||||||
|0 20|00 40|00 60|00 80|00 10|

2500000 2000000 1500000 1000000 TIme in n5ano0secon0ds000 0

-500000

n

Teóricamente si tenemos una array y estamos asignando estos valores a un HashMap la asignación debería de ser **O(n)** teniendo en cuenta que n es el tamaño del array. No obstante, debido a las colisiones esto no es siempre cierto, la cantidad de colisiones no es un valor constante por lo que no se puede medir exactamente. Por lo tanto, su complejidad **será un tanto mayor a O(n).** Sin embargo, sacando resultados, la grafica nos dice que se acerca a un crecimiento **exponencial** en el tiempo (R2 = 0.6964). Esto es debido a que cada vez que hayan más valores en el hashmap, es mas propenso a que hayan más colisiones, por lo tanto crece de manera exponencial de cierta manera, no obstante esto no es algo calculable al 100 por ciento. 
