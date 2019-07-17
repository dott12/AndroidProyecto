package com.example.grammarhelp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    DBAdapter db;
    ProcesosHF Procesos = new ProcesosHF();
    int numberID=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBAdapter(this);
       // InicializarBD();
        //getOneContact();
        cleanAll();


    }

    public void botonGetData(View view){
        //addRegistros();
       // getOneContact();
        //deleteContact();
        //StringToArray();
        //cleanAll();
        getAllContacts();
        //ClonarDato();
        //Palabra();
        //mostrarToast();
        //QueryPalabras("Haremos");

    }

    public void getAllContacts (){
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }

    public void toHomofonas (View view) {
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String wordToQ = editText3.getText().toString();

        Intent intent = new Intent(this, homofonasList.class);
        intent.putExtra("wTQ", wordToQ);
        startActivity(intent);
    }

    public void toPermisos (View view) {


        Intent intent = new Intent(this, permisos.class);
        startActivity(intent);
    }




    public void addRegistros(){
        // String name,  String meaning, String example, String counterpart
        db.open();
        long _id1 = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",0, "Haremos");
        long _id2 = db.insertContact("Haremos","Forma del verbo hacer","Haremos un mundo mejor",0, "Aremos");

        long _id3 = db.insertContact("Abrasar","Quemar algo","Abrasa el pollo para servirlo",0, "Abrazar");
        long _id4 = db.insertContact("Abrazar","Dar un abrazo","Los abrazos son buenos",0, "Abrasar");

        long _id5 = db.insertContact("A","Primera letra del alfabeto","La letra a es la mas usada en el español",0, "Ha");
        long _id6 = db.insertContact("Ha","Del verbo haber","El niño ha logrado ganar el campeonato",0, "a");

        long _id7 = db.insertContact("Abollar","Realizar abolladuras a un objeto de metal","El carro quedo abollado por las balas",0, "Aboyar");
        long _id8 = db.insertContact("Aboyar","Colocar boyas en el mar para detener redes o hacer limitaciones","Vimos a los a guardacostas aboyando la bahia.",0, "Abollar");

        long _id9 = db.insertContact("Asesinar","Matar, quitar una vida","Los soldados salen a asesinar a sus enemigos",0, "Acecinar");
        long _id10 = db.insertContact("Acecinar","Salar las carnes","Debemos acecinar esta carne para que tome buen sabor",0, "Asesinar");

        long _id11 = db.insertContact("Acerbo","Áspero o rugoso al gusto","El acerbo perfume de la mujer inundó la habitación",0, "Acervo");
        long _id12 = db.insertContact("Acervo","Conjunto de bienes o valores morales o culturales que pertenecen a un grupo","En esa comunidad existe un gran acervo cultural",0, "Acerbo");

        long _id13 = db.insertContact("Acético","Vinagre","El acético es un ácido muy daniño",0, "Ascético");
        long _id14 = db.insertContact("Ascético","Ermitaño o practicante de virtud","Yo era ascético pero ya no lo soy",0, "Acético");

        long _id15 = db.insertContact("Adolecente","Persona que se adolece; tiene dolor","El doctor tiene un adolecente que atender",0, "Adolescente");
        long _id16 = db.insertContact("Adolescente","Joven en etapa de desarrollo físico y psicológico","Un grupo de adolescentes va al cine a ver una película",0, "Adolecente");

        long _id17 = db.insertContact("Abría","Del verbo abrir","Yo tomaba agua mientras abría la puerta",0, "Habría");
        long _id18 = db.insertContact("Habría","Del verbo haber; tiene dolor","Habría llegado a tiempo si hubiese madrugado",0, "Abría");

        long _id19 = db.insertContact("Agito","Batir algo","Si agito la mezcla, se espesará",0, "Ajito");
        long _id20 = db.insertContact("Ajito","Diminutivo de la planta de ajo","Dos ajitos son suficientes para sazonar",0, "Agito");

        long _id21 = db.insertContact("Alaban","Adorar. A un dios por ejemplo","Los feligreses alaban a Dios sin cesar",0, "Halaban");
        long _id22 = db.insertContact("Halaban","Del verbo halar","Los hombres halaban la cuerda con toda su fuerza",0, "Alaban");

        long _id23 = db.insertContact("Ay","Interjección de dolor","¡Ay!, me lastimé el brazo",0, "Hay");
        long _id24 = db.insertContact("Hay","Del verbo haber","Hay dos manzanas en la mesa",0, "Ay");

        long _id25 = db.insertContact("Alón","Es el ala entera de cualquier ave","El alón de ese pájaro tiene un color muy llamativo",0, "Halón");
        long _id26 = db.insertContact("Halón","Es un gas químico","Actualmente se utiliza el gas inergén en lugar del halón",0, "Alón");

        long _id27 = db.insertContact("Ampón","Es la forma amplia o abombada de algo, especialmente, la de la falda de un vestido","A ella le gustó lo ampón que es ese vestido",0, "Hampón");
        long _id28 = db.insertContact("Hampón","Es un delincuente","La policia persigue con rapidez a ese hampón",0, "Ampón");

        long _id29 = db.insertContact("Arte","Trabajo plástico, pintura o escultura","Desde pequeño le gustó mucho el arte",0, "Harte");
        long _id30 = db.insertContact("Harte","Del verbo hartar","Voy a comer hasta que me harte",0, "Arte");

        long _id31 = db.insertContact("Arrollar","Volver rollo o atropellar a algo o alguien","Si no frenas vas a arrollar al pobre gato",0, "Arroyar");
        long _id32 = db.insertContact("Arroyar","Crear arroyos","El aguacero va a arroyar la ladera",0, "Arrollar");

        long _id33 = db.insertContact("Aprehender","Capturar","La policia se dirige a aprehender a los contrabandistas",0, "Aprender");
        long _id34 = db.insertContact("Aprender","Adquirir conocimientos, estudiar","Me he propuesto aprender varios idiomas",0, "Aprehender");

        long _id35 = db.insertContact("Has","Verbo haber","En todo este tiempo no has hecho la tarea",0, "Haz");
        long _id36 = db.insertContact("Haz","Verbo haber en imperativo","Haz la tarea y podrás salir a jugar",0, "Has");

        long _id37 = db.insertContact("Asar","Del verbo asar","En una hora empezaremos a asar la carne",0, "Azar");;
        long _id38 = db.insertContact("Azar","casualidad","Me gustan los juegos de azar",0, "Asar");

        long _id39 = db.insertContact("Ascenso","Promoción de una persona en su trabajo","El esta trabajando muy duro para lograr un ascenso",0, "Ascenso");
        long _id340 = db.insertContact("Asenso","Acción de asentir","Debo esperar el asenso de mis padres",0, "Asenso");

        long _id41 = db.insertContact("Asia","Continente","Estoy preparando un viaje a Asia",0, "Hacia");
        long _id42 = db.insertContact("Hacia","Prepocición","El bus debe girar hacia la derecha para llegar a su destino",0, "Asia");

        long _id43 = db.insertContact("Asta","Cuerno de animal; madero grande","Todos estaban concentrados en el asta de la bandera",0, "Hasta");
        long _id44 = db.insertContact("Hasta","Prepocición","He decidido correr hasta que me canse",0, "Asta");

        long _id45 = db.insertContact("Atajo","De atajar","Tomamos un atajo a la escuela",0, "Hatajo");
        long _id46 = db.insertContact("Hatajo","Rebaño de animales","Se estaban comportando como un hatajo de hienas",0, "Atajo");

        long _id47 = db.insertContact("Halla","De hallar","Dile que busque debajo de la cama, a ver si halla lo que se le perdió",0, "Haya");
        long _id48 = db.insertContact("Haya","De haber y ciudad de Holanda","Espero haya gente buena en ese pueblo",0, "Halla");

        long _id49 = db.insertContact("Hablando","Acto de hablar","Estabamos hablando de un tema muy importante",0, "Ablando");
        long _id50 = db.insertContact("Ablando","Suavizar algo","Buscaré un poco de agua a ver si con eso ablando la masa",0, "Hablando");

        long _id51 = db.insertContact("Bah","Expresión de desdén o desacuerdo","¡Bah!, no estoy de acuerdo con lo que él dice",0, "Va");
        long _id52 = db.insertContact("Va","Del verbo ir","El niño va a la tienda a hacer un mandado",0, "Bah");

        long _id53 = db.insertContact("Bacante","Adorador del dios Baco","Ese grupo de personas es bacante",0, "Vacante");
        long _id54 = db.insertContact("Vacante","Del verbo ir","Hay una vacante para el puesto de programador",0, "Bacante");

        long _id55 = db.insertContact("Bacía","Recipiente","Esa Bacía contiene agua",0, "Vacía");
        long _id56 = db.insertContact("Vacía","Desocupado","Ese jarrón está vacío",0, "Bacía");

        long _id57 = db.insertContact("Baqueta","Pieza para limpiar la escopeta; Pieza  para tocar la batería o tambor","Me compré dos pares de baquetas para el concierto",0, "Vaqueta");
        long _id58 = db.insertContact("Vaqueta","Cuero o lienzo de vaca","La vaqueta se emplea en marroquinería para elaborar sillones, maletas y otros objetos",0, "Baqueta");

        long _id59 = db.insertContact("Barón","Titulo nobiliario","Los grandes vasallos de Francia o de Inglaterra eran los altos barones",0, "Varón");
        long _id60 = db.insertContact("Varón","Hombre","Ese varón es muy elegante",0, "Barón");

        long _id61 = db.insertContact("Basto","Tosco o grosero","Me respondio de modo muy basto",0, "Vasto");
        long _id62 = db.insertContact("Vasto","Extenso","El mar es muy vasto",0, "Basto");

        long _id63 = db.insertContact("Valla","Construcción hecha de cualquier material para cercar un terreno","Una valla separa las dos parcelas",0, "Vaya");
        long _id64 = db.insertContact("Vaya","Del verbo ir","Vaya a recoger el premio",0, "Valla");


        db.close();
    }


    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2)+ "\n" +
                 " ",
                Toast.LENGTH_LONG).show();

    }

    public void getOneContact () {
        db.open();

        Cursor c = db.getContact(1);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }



    public void deleteContact (int c) {

        db.open();
        if (db.deleteContact(c)) {
            //Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, "Delete failed. " + String.valueOf(c), Toast.LENGTH_LONG).show();
        db.close();

    }

    public void mostrarToast(String str){

        //Toast.makeText(this, StringToArray("Ana"), Toast.LENGTH_LONG).show();

    }

    public String StringToArray(String palabra){
        String testString = "Ana";
        palabra = palabra.toUpperCase();
        String result="";
        char[] sToChar = palabra.toCharArray();

        for (int s=0;s<sToChar.length;s++){

            char c = sToChar[s];

            switch(c) {
                case 'A':
                    result = result + "1";
                    break;
                case 'N':
                    result = result + "14";
                    break;
                default:
                    // code block
                    }
        }
        return result;
    }

    public void QueryPalabras (String query){
        //String query="Haremos";
        String idWord="";
        String match="no match";
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                //query=getPalabra(c);
                if (query.equalsIgnoreCase(getPalabra(c))){
                    idWord=getID(c);
                    match = idWord+ " = "+ "match";
                }

                Toast.makeText(this, match, Toast.LENGTH_LONG).show();
            } while (c.moveToNext());
        }
        db.close();
    }

    public String getPalabra(Cursor c){
        return c.getString(1);
    }

    public String getID(Cursor c){
        return c.getString(0);
    }

    public void cleanAll(){
        int n=0;
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                n=Integer.parseInt(getID(c));
                //showToast(String.valueOf(n));
                deleteContact(n);
            } while (c.moveToNext());
        }
        db.close();
        addRegistros();
    }

    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    }


}
