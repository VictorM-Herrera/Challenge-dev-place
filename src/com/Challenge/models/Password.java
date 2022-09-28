package com.Challenge.models;

public class Password {
    private int longitud;
    private String contrasena;

    //Constructor por defecto:
    public Password(){
        longitud=8;
        contrasena ="";
    }
    //Constructor con la longitud de la contraseña, y la contraseña generada automaticamente
    public Password(int longitud)
    {
        this.longitud=longitud;
        contrasena =generaPassword();
    }
    //Constructor con la contraseña y la longitud por defecto en 8
    public Password(String contrasena)
    {
        longitud=8;
        this.contrasena=contrasena;
    }

    /**
     * @return retorna un booleano true si la contraseña ingresada es fuerte, y false si no lo es
     * esta funcion toma en cuenta la consigna y verifica si la contraseña ingresada tiene mas de 2 mayusculas, mas de 1 minuscula y mas de 3 numeros
     * */
    public boolean esFuerte()
    {
        boolean esFuerte= false;
        int mayus=0;
        int minus=0;
        int numeros=0;
        for (int i=0; i< getContrasena().length();i++)
        {
            if(Character.isUpperCase(getContrasena().charAt(i)))
            {
                mayus++;
            }
            if (Character.isLowerCase(getContrasena().charAt(i)))
            {
                minus++;
            }
            if (Character.isDigit(getContrasena().charAt(i)))
            {
                numeros++;
            }
        }
        if(mayus>2)
        {
            if (minus>1)
                if (numeros>3)
                    esFuerte=true;
        }
        return esFuerte;
    }
    /**
     * @return retorna un String con una contraseña aleatoria
     * esta funcion tiene dentro un String con todas las letras (mayus, minus), y todos los numeros (0-9)
     * asigna un valor aleatorio (del String "letrasYNumeros") a cada espacio de un string builder (el limite esta asignado por la longitud de la contraseña) para poder formar la contraseña.
     * */
    public String generaPassword()
    {
        StringBuilder sb= new StringBuilder(getLongitud());
        String letrasYNumeros= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" + "0123456789";
        for (int i=0; i< getLongitud(); i++)
        {
            int j= (int)(letrasYNumeros.length()*Math.random());
            sb.append(letrasYNumeros.charAt(j));
        }
        return sb.toString();
    }

    //getter y setter de longitud
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    //getter de contraseña
    public String getContrasena() {
        return contrasena;
    }

    //override del toString para la informacion completa
    @Override
    public String toString() {
        return "Password{" +
                "longitud=" + longitud +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
