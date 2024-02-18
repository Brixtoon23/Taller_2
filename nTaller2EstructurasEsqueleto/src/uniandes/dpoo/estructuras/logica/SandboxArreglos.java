package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Random;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copyArregloEnteros = Arrays.copyOf(arregloEnteros,arregloEnteros.length);
        return copyArregloEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copyArregloCadenas = Arrays.copyOf(arregloCadenas,arregloCadenas.length);
        return copyArregloCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int lengthEnteros = arregloEnteros.length;
        return lengthEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int lengthCadenas = arregloCadenas.length;
        return lengthCadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	arregloEnteros = Arrays.copyOf(arregloEnteros,(arregloEnteros.length + 1));
    	arregloEnteros[arregloEnteros.length-1] = entero;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	arregloCadenas = Arrays.copyOf(arregloCadenas,(arregloCadenas.length + 1));
    	arregloCadenas[arregloCadenas.length-1] = cadena;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    
    public void eliminarEntero( int valor )
    {
    	int ward = 0;
    	for(int element : arregloEnteros)
    	{ 
    		if (element == valor) 
    		{
    			ward ++;
    		}
    	}
    	if (ward != 0) 
    	{
    		int[]arregloChange = new int[arregloEnteros.length - ward];
        	int newIndex=0;
    		for(int l=0; l< arregloEnteros.length; l++)
        	{
        		if (arregloEnteros[l] != valor)
        		{
        			arregloChange[newIndex]=arregloEnteros[l];
        			newIndex++;
        		}
        	}
    		arregloEnteros = arregloChange;
    	}
    	
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int ward = 0;
    	for(String element : arregloCadenas)
    	{ 
    		if (element.equals(cadena)) 
    		{
    			ward ++;
    		}
    	}
    	if (ward != 0) 
    	{
    		String[]arregloChange = new String[arregloCadenas.length-ward];
        	int newIndex=0;
    		for(int i=0; i< arregloCadenas.length; i++)
        	{
        		if (arregloCadenas[i] != cadena)
        		{
        			arregloChange[newIndex]=arregloCadenas[i];
        			newIndex++;
        		}
        	}
    		arregloCadenas = arregloChange;
    	}
    	
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion < 0)
    	{
    		posicion = 0;
    	}
    	else if (posicion > arregloEnteros.length)
    	{
    		posicion = arregloEnteros.length;
    	}
    	int[] arregloChange = new int[arregloEnteros.length + 1];
    	int[] arregloChange1 = Arrays.copyOfRange(arregloEnteros,0,posicion);
    	int[] arregloChange2 = Arrays.copyOfRange(arregloEnteros,posicion,arregloEnteros.length);
    	System.arraycopy(arregloChange1 , 0 , arregloChange , 0 , arregloChange1.length);
    	arregloChange[arregloChange1.length] = entero;
    	System.arraycopy(arregloChange2, 0, arregloChange, (arregloChange1.length+1), arregloChange2.length);
    	arregloEnteros = arregloChange;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if ((posicion < arregloEnteros.length) && (posicion >= 0) )
    	{
    		int[] arregloChange = new int[arregloEnteros.length - 1];
        	System.arraycopy(arregloEnteros , 0 , arregloChange , 0 , posicion);
        	System.arraycopy(arregloEnteros, posicion, arregloChange, posicion , (arregloEnteros.length - 1 - posicion));
        	arregloEnteros = arregloChange;
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arregloChange = new int[valores.length];
        for (int l = 0; l < valores.length; l++) {
        	arregloChange[l] = (int) valores[l];
        }
        arregloEnteros = arregloChange;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] arregloChange = new String[objetos.length];
        for (int l = 0; l < objetos.length; l++) 
        {
        	arregloChange[l] = objetos[l].toString();
        }
        arregloCadenas = arregloChange;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int l = 0; l < arregloEnteros.length; l++) 
    	{
            if (arregloEnteros[l] < 0) 
            {
                arregloEnteros[l] = -arregloEnteros[l];    			
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    { 
    for (int l = 1; l < arregloEnteros.length; ++l) {
        int key = arregloEnteros[l];
        int k = l - 1;

        // Mover los elementos de arregloEnteros[0..l-1] que son
        // mayores que la llave a una posición adelante de su posición actual
        while (k >= 0 && arregloEnteros[k] > key) {
            arregloEnteros[k + 1] = arregloEnteros[k];
            k = k - 1;
        }
        arregloEnteros[k + 1] = key;
    }
}
    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	if (arregloCadenas.length >1)
    	{
	        for (int l = 1; l < arregloCadenas.length; ++l) 
	        {
	            String key = arregloCadenas[l];
	            int k = l - 1;
	
	            while (k >= 0 && arregloCadenas[k].compareTo(key) > 0) 
	            {
	                arregloCadenas[k + 1] = arregloCadenas[k];
	                k = k - 1;
	            }
	            arregloCadenas[k + 1] = key;
	        }
    	}
    }
    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {   
    	int ward =0;
    	for (int l= 0; l < arregloEnteros.length; l++ )
    	{ 
    		if (arregloEnteros[l]== valor)
    		{
			ward++;
			
    		}
		
    	}
    	return ward;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	String cadenaProve = cadena.toLowerCase();
    	int ward = 0;
    	for (int l = 0; l < arregloCadenas.length; l++)
    	{
    		if(cadenaProve.equals(arregloCadenas[l].toLowerCase()))
    		{
    			ward++;	
    		}
    	}		
    	return ward;	
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int size = contarApariciones( valor);
    	int ward = 0;
    	int[] arregloPositions = new int[0];
    	if (size != 0)
    	{
    		arregloPositions = new int[size];
    		for (int l = 0; l < arregloEnteros.length; l++)
    		{
    			if (arregloEnteros[l]== valor) 
    			{
    				arregloPositions[ward]=l;
    				ward++;
    			}
    		}
    	}
		return arregloPositions;	
		
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
	    int[] arregloRange = arregloEnteros;
	    if (arregloEnteros.length != 0) 
	    {
	        double top = Double.NEGATIVE_INFINITY;
	        double down = Double.POSITIVE_INFINITY;
	        for (int l = 0; l < arregloEnteros.length; l++) 
	        {
	            if (arregloEnteros[l] > top) {
	                top = arregloEnteros[l];
	            }
	            if (arregloEnteros[l] < down) {
	                down = arregloEnteros[l];
	            }
	        }
	        arregloRange = new int[2];
	        arregloRange[0] = (int) down;
	        arregloRange[1] = (int) top;
    }
    return arregloRange;
}


    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();

        for (int element : arregloEnteros) 
        {
            histograma.put(element, histograma.getOrDefault(element, 0) + 1);
        }

        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos() 
    {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int element : arregloEnteros) 
        {
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }

        int wards = 0;
        for (int frequencyValue : frequency.values()) 
        {
            if (frequencyValue > 1) 
            {
                wards++;
            }
        }

        return wards;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros(int[] otroArreglo) 
    {
        if (arregloEnteros.length != otroArreglo.length) 
        {
            return false;
        }

        for (int l = 0; l < arregloEnteros.length; l++) 
        {
            if (arregloEnteros[l] != otroArreglo[l]) 
            {
                return false;
            }
        } 
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) 
    {
        if (arregloEnteros.length != otroArreglo.length) 
        {
            return false;
        }

        int[] arregloEnteros2 = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] otroArreglo2 = Arrays.copyOf(otroArreglo, otroArreglo.length);

        Arrays.sort(arregloEnteros2);
        Arrays.sort(otroArreglo2);

        return Arrays.equals(arregloEnteros2, otroArreglo2);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param down El valor mínimo para los números generados
     * @param top El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int down, int top) 
    {
        Random random = new Random();

        arregloEnteros = new int[cantidad];

        for (int l = 0; l < cantidad; l++) 
        {
            arregloEnteros[l] = random.nextInt(top - down + 1) + down;
        }
    }
}
