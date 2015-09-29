package com.gastongimenez.www.gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by Tonga on 09/03/2015.
 */

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {
    //Métodos de SQLiteOpenHelper
    public BaseDeDatos(Context context) {
        super(context, "BDGestion", null, 1);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE clientes ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombre TEXT, " +
                "rut TEXT, " +
                "telefono_1 TEXT," +
                "telefono_2 TEXT)");
        db.execSQL("INSERT INTO CLIENTES VALUES (null,'CLIENTE1','3243243',234234,234324)");
        db.execSQL("INSERT INTO CLIENTES VALUES (null,'CLIENTE2','3243243',234234,234324)");
        db.execSQL("INSERT INTO CLIENTES VALUES (null,'CLIENTE3','3243243',234234,234324)");
        db.execSQL("INSERT INTO CLIENTES VALUES (null,'CLIENTE4','3243243',234234,234324)");

        db.execSQL("CREATE TABLE productos ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombre TEXT," +
                "cantidad_pack TEXT," +
                "cantidad_stock INTEGER," +
                "precio_pack REAL," +
                "precio_unitario REAL," +
                "precio_publico TEXT"+
                ")");

        //db.execSQL("INSERT INTO PRODUCTOS VALUES (null, 'KetchupMayonesa','100',5, 120,1.20,'2 x $5')");
        //db.execSQL("INSERT INTO PRODUCTOS VALUES (null, 'Ganja','25 g',10, 750,750,'800')");
        db.execSQL("insert into productos values(null,'CarameloFrutas','145',0,66,0.62,'1')");
        db.execSQL("insert into productos values(null,'GuacoKroy','70',0,142,2,'2 x 5')");
        db.execSQL("insert into productos values(null,'Yogurth 700g','130',0,70,0.54,'1')");
        db.execSQL("insert into productos values(null,'Caramelo Olimpo (mta,miel,croc,acid)','120',0,93,0.8,'2x3')");
        db.execSQL("insert into productos values(null,'Candel Ronda','80',0,80,1,'2x3')");
        db.execSQL("insert into productos values(null,'Masticable 300gr.','100',0,25,0.25,'3x1')");
        db.execSQL("insert into productos values(null,'MytoffeLeche y Choco','115',0,108,0.94,'2x3')");
        db.execSQL("insert into productos values(null,'Ben Hurt Casquito 500g','85',0,82,0.96,'2x3')");
        db.execSQL("insert into productos values(null,'Ben Hurt Fruta 500g','75',0,82,1.09,'2x3')");
        db.execSQL("insert into productos values(null,'Caramelo Frutilla DORI','135',0,75,0.55,'1')");
        db.execSQL("insert into productos values(null,'Pocket Café','175',0,100,0.57,'1')");
        db.execSQL("insert into productos values(null,'Santa Rita de Leche','130',0,93,0.7,'1')");
        db.execSQL("insert into productos values(null,'SUGUS masticable','210',0,162,0.77,'1')");
        db.execSQL("insert into productos values(null,'CarameloZabala','100',0,163,1.63,'2')");
        db.execSQL("insert into productos values(null,'Marengo Frutilla y Menta','105',0,42,0.4,'2x1')");
        db.execSQL("insert into productos values(null,'Palito Zoo Masticable','151',0,118,0.78,'1')");
        db.execSQL("insert into productos values(null,'Miel Dori','0',0,0,70,'0')");
        db.execSQL("insert into productos values(null,'ChicleBUBALOO','60',0,100,1.66,'2')");
        db.execSQL("insert into productos values(null,'Chicle BLONG','40',0,32,0.8,'1')");
        db.execSQL("insert into productos values(null,'Chicle BOMKY SIMPSON','120',0,44,0.36,'2x1')");
        db.execSQL("insert into productos values(null,'ChicleBuzzyBoll','60',0,45,0.75,'1')");
        db.execSQL("insert into productos values(null,'Chicle Bola FINI (sandia,nar,mel)','120',0,94,0.78,'1')");
        db.execSQL("insert into productos values(null,'Chiclet´s ADAM’S','100',0,164,1.64,'2')");
        db.execSQL("insert into productos values(null,'Chiclet´s ADAM’S (GDE)','30',0,255,8.5,'10')");
        db.execSQL("insert into productos values(null,'ChicleBELDENT','20',0,220,11,'14')");
        db.execSQL("insert into productos values(null,'ChicleBeldent Sensation','12',0,181,15,'18')");
        db.execSQL("insert into productos values(null,'ChicleHuevito ARCOR','12',0,55,4.58,'6')");
        db.execSQL("insert into productos values(null,'Chicle Vampiro (acido y pintalengua)','200',0,158,0.79,'1')");
        db.execSQL("insert into productos values(null,'Chupetín c/relleno','50',0,40,0.8,'1')");
        db.execSQL("insert into productos values(null,'Chupetin COSMOS','42',0,31,0.74,'1')");
        db.execSQL("insert into productos values(null,'Chupetín Amor Peccing','24',0,45,1.88,'2x5')");
        db.execSQL("insert into productos values(null,'Paletón x20','20',0,96,4.8,'6')");
        db.execSQL("insert into productos values(null,'Chupetin Super acidoOlimpo','60',0,94,1.56,'2')");
        db.execSQL("insert into productos values(null,'PaletongrandeOlimpo Cajax12','0',0,150,0,'0')");
        db.execSQL("insert into productos values(null,'Mentas LA CASA','12',0,120,10,'12')");
        db.execSQL("insert into productos values(null,'Frutal DOCILE   mini5','100',0,60,0.6,'1')");
        db.execSQL("insert into productos values(null,'Coloretti (rocklets)','1kg',0,198,0,'100g x 25')");
        db.execSQL("insert into productos values(null,'Disqueti mini','500grs',0,128,0,'0')");
        db.execSQL("insert into productos values(null,'Coloretti Packs x 18grs','24',0,108,4.5,'6')");
        db.execSQL("insert into productos values(null,'DeliquetConfitado','1kg',0,80,0,'100g x 12')");
        db.execSQL("insert into productos values(null,'Past. FREEGEL´S (12 sabores)','12',0,45,3.75,'5')");
        db.execSQL("insert into productos values(null,'Minty (tic tac)','12',0,96,8,'10')");
        db.execSQL("insert into productos values(null,'Mentos (frutal, frutilla, tuti, menta)','12',0,115,9.58,'12')");
        db.execSQL("insert into productos values(null,'Past. HALLS','12',0,120,10,'12')");
        db.execSQL("insert into productos values(null,'Coloreti ball','20',0,78,3.9,'5')");
        db.execSQL("insert into productos values(null,'Gomas FINI 500g','125',0,98,0.78,'1')");
        db.execSQL("insert into productos values(null,'GometsAritos','160',0,62,0.39,'2x1')");
        db.execSQL("insert into productos values(null,'Gomatubo x8 DORI','30',0,85,2.83,'5')");
        db.execSQL("insert into productos values(null,'Gomatubo x8 FLORESTAL','30',0,75,2.5,'4')");
        db.execSQL("insert into productos values(null,'FrutillaOlimpo','50',0,118,2.36,'3')");
        db.execSQL("insert into productos values(null,'Mini goma DORI','30',0,96,3.6,'5')");
        db.execSQL("insert into productos values(null,'Goma Docile OSITO','30',0,60,2,'4')");
        db.execSQL("insert into productos values(null,'Goma FINI ROLLER','24',0,94,3.91,'5')");
        db.execSQL("insert into productos values(null,'Goma GOMUTCHO','0',0,0,8,'10')");
        db.execSQL("insert into productos values(null,'CHICHE Punta Pallena','16',0,75,4.68,'6')");
        db.execSQL("insert into productos values(null,'AlfajorPlay love y PLAY','16',0,109,6.75,'8')");
        db.execSQL("insert into productos values(null,'Top Punta Ballena','12',0,106,8.8,'11')");
        db.execSQL("insert into productos values(null,'Play triple  Punta Ballena','10',0,98,9.8,'13')");
        db.execSQL("insert into productos values(null,'Surprise Punta Ballena','12',0,170,14.16,'17')");
        db.execSQL("insert into productos values(null,'Portezueloclasico','18',0,148,8.22,'10')");
        db.execSQL("insert into productos values(null,'Porezuelo Soft','18',0,148,8.22,'10')");
        db.execSQL("insert into productos values(null,'Portezuelo Triple','12',0,140,11.66,'14')");
        db.execSQL("insert into productos values(null,'Portezuelo Doble dulce de leche','14',0,139.5,9.96,'12')");
        db.execSQL("insert into productos values(null,'Portezuelo Extra DL Black Triple','12',0,155,12.5,'16')");
        db.execSQL("insert into productos values(null,'AlfajorNATIVO (Artesanal)','12',0,220,18.33,'23')");
        db.execSQL("insert into productos values(null,'Nicolox 23g ','30',0,160,5.26,'7')");
        db.execSQL("insert into productos values(null,'Tableta GOLDEN ','15',0,128,8.53,'12')");
        db.execSQL("insert into productos values(null,'Tableta GAROTO x150gr','12',0,0,53,'0')");
        db.execSQL("insert into productos values(null,'Chocolate de taza Alteza 90gr','0',0,0,25,'0')");
        db.execSQL("insert into productos values(null,'Bombon COMPLICE','30',0,120,4,'5')");
        db.execSQL("insert into productos values(null,'Bombon BOB ESPONJA','50',0,82,1.64,'2')");
        db.execSQL("insert into productos values(null,'Batón','30',0,230,7.66,'10')");
        db.execSQL("insert into productos values(null,'Baton JAZAM','30',0,110,3.66,'5')");
        db.execSQL("insert into productos values(null,'Barra Cereales CEREANOLA','24',0,189,7.88,'10')");
        db.execSQL("insert into productos values(null,'Wafle Triangulo','48',0,77,1.6,'2')");
        db.execSQL("insert into productos values(null,'Tab Golden chica','20',0,78,3.9,'5')");
        db.execSQL("insert into productos values(null,'Ticholo Mariola','50',0,88,1.76,'2X5')");
        db.execSQL("insert into productos values(null,'Nucita','48',0,76,1.58,'2')");
        db.execSQL("insert into productos values(null,'Rapadura','60',0,96,1.6,'2')");
        db.execSQL("insert into productos values(null,'Barquillo CH Y DL','60',0,96,1.6,'2')");
        db.execSQL("insert into productos values(null,'Barquillo bañado crock roll','30',0,133,4.43,'6')");
        db.execSQL("insert into productos values(null,'Palitos Salados (Jam. Ques. Panceta)','1kg',0,135,13.5,'100gr x $18')");
        db.execSQL("insert into productos values(null,'Mani Artesanal (Con y Sin Sal)','1kg',0,135,13.5,'100gr x $18')");
        db.execSQL("insert into productos values(null,'Mani Salado STA. HELENA Bolsa 20gr.','50',0,180,3.6,'5')");
        db.execSQL("insert into productos values(null,'Mani Salado STA. HELENA 60gr.','30',0,0,10,'12')");
        db.execSQL("insert into productos values(null,'Mani Salado STA. HELENA 200gr.','24',0,0,30,'36')");
        db.execSQL("insert into productos values(null,'Mani Japonés Dori 100gr.','30',0,0,12.6,'16')");
        db.execSQL("insert into productos values(null,'Mani C/Chocolate Dori 100gr.','30',0,0,12.6,'16')");
        db.execSQL("insert into productos values(null,'Mani C/Chocolate Dori 70gr.','30',0,0,10,'13')");
        db.execSQL("insert into productos values(null,'Mani C/Chocolate COLONIAL x24gr','16',0,144,9,'12')");
        db.execSQL("insert into productos values(null,'SaladitoHorneadoTrofeú','20',0,190,9.5,'12')");
        db.execSQL("insert into productos values(null,'Papas KRACHITOS x 20gr. TIRA','6',0,58.2,9.7,'12')");
        db.execSQL("insert into productos values(null,'Papas KRACHITOS x 120gr.','0',0,49.2,0,'60')");
        db.execSQL("insert into productos values(null,'Combo CHARLY (2 pap. 120g y 2 mani)','0',0,106,0,'126')");
        db.execSQL("insert into productos values(null,'Sopladitos de Queso ORES','100grs',0,0,22.5,'28')");
        db.execSQL("insert into productos values(null,'Sopladitos de Queso BUBY','210grs',0,0,44.5,'50')");
        db.execSQL("insert into productos values(null,'Sopladitis de Queso BUBY','100grs',0,0,22.5,'28')");
        db.execSQL("insert into productos values(null,'Papas Pay ORES','500g',0,0,140,'0')");
        db.execSQL("insert into productos values(null,'Café SAINT','100',0,114,1.14,'2x3')");
        db.execSQL("insert into productos values(null,'Té SAINT','100',0,94,0.94,'2x3')");
        db.execSQL("insert into productos values(null,'Colet SAINT x10gr.','50',0,48,0.96,'2x3')");
        db.execSQL("insert into productos values(null,'Bracafecito Nescafe','120',0,193,1.6,'2')");
        db.execSQL("insert into productos values(null,'Café Aguila Stick','240',0,193,0.8,'1')");
        db.execSQL("insert into productos values(null,'Mayonesa Uruguay 125cc ','20',0,230,11.5,'15')");
        db.execSQL("insert into productos values(null,'Mayonesa Uruguay  500gr','15',0,0,38.8,'47')");
        db.execSQL("insert into productos values(null,'Arroz Green Chef x1kg','20',0,558,28,'33')");
        db.execSQL("insert into productos values(null,'AceiteOptimo','15',0,825,57,'66')");
        db.execSQL("insert into productos values(null,'AceiteCondesa','15',0,0,33.5,'0')");
        db.execSQL("insert into productos values(null,'Pure de papa LIDER x120gr','20',0,0,16.8,'21')");
        db.execSQL("insert into productos values(null,'Cereal c/azúcar TORRE NUEVA','1,5kg',0,182,121.33,'18')");
        db.execSQL("insert into productos values(null,'Cereal Arito Frutado TORRE NUEVA ','  1,5Kg',0,218,14.5,'18')");
        db.execSQL("insert into productos values(null,'Levadura Levachef','20',0,118,5.9,'8')");
        db.execSQL("insert into productos values(null,'Polvo Royal x30gr','16',0,134.4,8.4,'10')");
        db.execSQL("insert into productos values(null,'Extracto de tomate PIZER 60gr','12',0,129,10.75,'14')");
        db.execSQL("insert into productos values(null,'Tabletas Raid','24',0,118,4.92,'6')");
        db.execSQL("insert into productos values(null,'Insecticida  SAPOLIO','12',0,0,69,'83')");
        db.execSQL("insert into productos values(null,'Desodorante Amb. SAPOLIO','12',0,556,48.5,'0')");
        db.execSQL("insert into productos values(null,'Desodorante Amb. GLADE ','12',0,552,46,'55')");
        db.execSQL("insert into productos values(null,'Lysoform (Original, BB, Floral,avanda)','12',0,0,90,'106')");
        db.execSQL("insert into productos values(null,'Mr. Musculo Pisos x900ml(tipo Fabuloso)','12',0,374,33,'-')");
        db.execSQL("insert into productos values(null,'Mr. Musculo Pisos x1,800lts','8',0,451,58.7,'-')");
        db.execSQL("insert into productos values(null,'Encendedor económico RONSON (trnsp)','25',0,212,8.5,'10')");
        db.execSQL("insert into productos values(null,'Encendedor BIC','50',0,0,24,'30')");
        db.execSQL("insert into productos values(null,'Pilas Everreadi Chicas','4',0,18.6,4.65,'6')");
        db.execSQL("insert into productos values(null,'Pilas Everreadi Mediana','24',0,252,10.8,'13')");
        db.execSQL("insert into productos values(null,'Pilas Everreadi Grande','24',0,288,12,'15')");
        db.execSQL("insert into productos values(null,'Pilas Panasonic Alcalina (AA y AAA)','20',0,243,12.15,'16')");
        db.execSQL("insert into productos values(null,'Pilas Panasonic chica','4',0,309,20.6,'7')");
        db.execSQL("insert into productos values(null,'Pilas Panasonic Grande (com)','24',0,336,14,'17')");
        db.execSQL("insert into productos values(null,'Pilas Alcalina Grande POLAROID ','2',0,120,60,'75')");
        db.execSQL("insert into productos values(null,'WaflesMY BIT','30',0,300,10.9,'13')");
        db.execSQL("insert into productos values(null,'GalletitaRellena EURO','30',0,240,8.3,'10')");
        db.execSQL("insert into productos values(null,'Galletita Rellena Zabet x4 tubos','0',0,0,31,'0')");
        db.execSQL("insert into productos values(null,'Isabela Integral x3 400grs','20',0,640,33.5,'40')");
        db.execSQL("insert into productos values(null,'Isabela Sal y Agua x3','20',0,0,33,'41')");
        db.execSQL("insert into productos values(null,'IasabelaMaicena x3','20',0,0,33,'41')");
        db.execSQL("insert into productos values(null,'Isabela Maria x3','20',0,0,33,'41')");
        db.execSQL("insert into productos values(null,'Maria VITORIA 100g','34',0,0,9,'12')");
        db.execSQL("insert into productos values(null,'GalletaNinffa x2 (370gr)','20',0,0,25,'30')");
        db.execSQL("insert into productos values(null,'Galleta ORQUIDEA x400gr','20',0,0,20,'0')");
        db.execSQL("insert into productos values(null,'Galleta Surtida Don Paolo 350grs','14',0,365,26,'33')");
        db.execSQL("insert into productos values(null,'GalletaPepasFatay350grs','16',0,560,35,'44')");
        db.execSQL("insert into productos values(null,'Galleta Chips Festiva 350gr Chispas ch','0',0,0,35,'44')");
        db.execSQL("insert into productos values(null,'Galleta Surtida Festiva 350gr','0',0,0,32,'0')");
        db.execSQL("insert into productos values(null,'ZezePlantillas (Vainill, Choc, Limon)','18',0,530,33,'40')");
        db.execSQL("insert into productos values(null,'Zeze Luna (tipoPanina)','15',0,403,30,'38')");
        db.execSQL("insert into productos values(null,'Palitos ZABET ','40',0,548,15,'20')");
        db.execSQL("insert into productos values(null,'Galletita NATIVO 80gr','0',0,0,16,'20')");
        db.execSQL("insert into productos values(null,'Jugo BIG C 250ml','27',0,283.5,10.5,'13')");
        db.execSQL("insert into productos values(null,'Jugo BIG C 1L','12',0,0,38,'46')");
        db.execSQL("insert into productos values(null,'JugoRinde 2','20',0,235,11.75,'15')");
        db.execSQL("insert into productos values(null,'JugoFoky','20',0,156,7.8,'10')");
        db.execSQL("insert into productos values(null,'Perifar 400','8',0,0,30,'0')");
        db.execSQL("insert into productos values(null,'Perifar 600','8',0,0,40,'0')");
        db.execSQL("insert into productos values(null,'Perifar Flex','8',0,0,56,'0')");
        db.execSQL("insert into productos values(null,'Perifar Niño','10',0,0,41,'0')");
        db.execSQL("insert into productos values(null,'Perifar Grip','8',0,0,61,'0')");
        db.execSQL("insert into productos values(null,'Perifar Fem','8',0,0,52,'0')");
        db.execSQL("insert into productos values(null,'PerifarMigra','8',0,0,77,'0')");
        db.execSQL("insert into productos values(null,'PerifarEspasmo','8',0,0,80,'0')");
        db.execSQL("insert into productos values(null,'Perifar Grip Soluble','30',0,0,23,'0')");
        db.execSQL("insert into productos values(null,'Perifar 600 C/Blanda','10',0,0,70,'0')");
        db.execSQL("insert into productos values(null,'Aspirina','10',0,0,30,'0')");
        db.execSQL("insert into productos values(null,'Aspirina Fuerte','10',0,0,30,'0')");
        db.execSQL("insert into productos values(null,'Aspirina C','24',0,0,19.5,'0')");
        db.execSQL("insert into productos values(null,'Aspirina CC','24',0,0,19.5,'0')");
        db.execSQL("insert into productos values(null,'Aspirineta','7',0,0,35,'0')");
        db.execSQL("insert into productos values(null,'Cardioaspirina','5',0,0,49,'0')");
        db.execSQL("insert into productos values(null,'Zolben','8',0,0,39,'0')");
        db.execSQL("insert into productos values(null,'Novemina','25',0,0,29,'0')");
        db.execSQL("insert into productos values(null,'Novemina Flex','8',0,0,55,'0')");
        db.execSQL("insert into productos values(null,'Negatos','10',0,0,65,'0')");
        db.execSQL("insert into productos values(null,'Dorixina','10',0,0,72,'0')");
        db.execSQL("insert into productos values(null,'Plidex','20',0,0,120,'0')");
        db.execSQL("insert into productos values(null,'Sertal Compuesto','10',0,0,138,'0')");
        db.execSQL("insert into productos values(null,'BioGrip Soluble','0',0,0,21.5,'0')");
        db.execSQL("insert into productos values(null,'Uvasal','12',0,0,9,'0')");
        db.execSQL("insert into productos values(null,'Alikal','12',0,130,11,'0')");
        db.execSQL("insert into productos values(null,'Yasta','24',0,276,12.5,'0')");
        db.execSQL("insert into productos values(null,'ACF 4 Comprimido','8',0,0,53,'0')");
        db.execSQL("insert into productos values(null,'ACF – C ','30',0,450,15,'0')");
        db.execSQL("insert into productos values(null,'Borweb','10',0,0,62,'0')");
        db.execSQL("insert into productos values(null,'Ernex','5',0,0,32,'0')");
        db.execSQL("insert into productos values(null,'IBUMIDOL rapidaaccion','10',0,0,54,'0')");
        db.execSQL("insert into productos values(null,'IBUMIDOL PLUS rapidaaccion','10',0,0,56,'0')");
        db.execSQL("insert into productos values(null,'Actrón 200','10',0,0,36,'0')");
        db.execSQL("insert into productos values(null,'Actrón 400','10',0,0,55,'0')");
        db.execSQL("insert into productos values(null,'Actrón 600','10',0,0,87,'0')");
        db.execSQL("insert into productos values(null,'Omeprazol','6',0,0,45,'0')");
        db.execSQL("insert into productos values(null,'Omepracid','10',0,0,80,'0')");
        db.execSQL("insert into productos values(null,'Tabcin Caliente','20',0,0,20.5,'0')");
        db.execSQL("insert into productos values(null,'Bisal','25',0,0,30,'0')");
        db.execSQL("insert into productos values(null,'Dolex (Paracetamol 650mg)','8',0,0,32,'0')");
        db.execSQL("insert into productos values(null,'Sinutabcomp.','12',0,0,90,'0')");
        db.execSQL("insert into productos values(null,'','0',0,0,0,'0')");
        db.execSQL("insert into productos values(null,'PANTENE shamp y acond. (tira)','24',0,98,4.08,'0')");
        db.execSQL("insert into productos values(null,'Head and Shoulder´s ','24',0,98,4.08,'6')");
        db.execSQL("insert into productos values(null,'Pañuelo Elite','10',0,58,5.8,'8')");
        db.execSQL("insert into productos values(null,'Curitas Ready-PLAST','80',0,130,1.63,'2')");
        db.execSQL("insert into productos values(null,'Azufre','50',0,96,1.92,'3')");
        db.execSQL("insert into productos values(null,'Des. Speed Stick mini (HyM)','6',0,186,31,'39')");
        db.execSQL("insert into productos values(null,'Prestobarbaazul x24+4A','28',0,693,24.75,'-')");
        db.execSQL("insert into productos values(null,'Prestobarba triple hoja 10+2','12',0,450,37.5,'-')");
        db.execSQL("insert into productos values(null,'Shick Exacta','0',0,0,18,'0')");
        db.execSQL("insert into productos values(null,'Jabón de tocador SENSUS','0',0,0,14.6,'0')");
        db.execSQL("insert into productos values(null,'Jabón de tocador ASTRAL','0',0,0,19,'0')");
        db.execSQL("insert into productos values(null,'Dulce ½ kg','0',0,0,38,'46')");
        db.execSQL("insert into productos values(null,'Dulce 1 kg','0',0,0,66,'79')");
        db.execSQL("insert into productos values(null,'Dulce 3 ½ kg','0',0,0,205,'70 el kg')");
        db.execSQL("insert into productos values(null,'Dulce 5 kg','0',0,0,290,'70 el kg')");
        db.execSQL("insert into productos values(null,'Dulce REPOSTERO','0',0,0,300,'75 el kg')");
        db.execSQL("insert into productos values(null,'Muzzarella (4kg aprox.)','0',0,0,168,'22')");
        db.execSQL("insert into productos values(null,'Oregano','1 kg.',0,194,0,'0')");
        db.execSQL("insert into productos values(null,'Adobo','1 kg.',0,155,0,'0')");
        db.execSQL("insert into productos values(null,'Ajo y Perejil','1 kg.',0,185,0,'0')");



        db.execSQL("CREATE TABLE pedidos ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "id_cliente INTEGER REFERENCES clientes(_id)," +
                "fecha INTEGER, " +
                "hora INTEGER," +
                "importe_total REAL)");

        db.execSQL("CREATE TABLE lineas_pedidos ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_pedido INTEGER REFERENCES pedidos(_id)," +
                "correlativo_linea INTEGER," +
                "id_producto INTEGER REFERENCES productos (_id)," +
                "cantidad INTEGER," +
                "precio_unitario REAL)");

        db.execSQL("CREATE UNIQUE INDEX uniq1_lineas_pedidos ON lineas_pedidos(id_pedido,correlativo_linea)");

    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }


    public Vector<String> listaPuntuaciones(int cantidad) {
        Vector<String> result = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT puntos FROM " +
                "puntuaciones ORDER BY puntos DESC LIMIT " +cantidad, null);
        while (cursor.moveToNext()){
            result.add(Integer.toString(cursor.getInt(0)));
        }
        cursor.close();
        db.close();
        return result;
    }
}