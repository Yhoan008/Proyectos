

let time;
let estate;



function changeState(estate){
    if (estate == "pm" || estate=="PM" || estate=="Pm"){
        estate="am";
    }
    else if(estate=="am" || estate=="AM" || estate=="Am"){
        estate="pm";
    }
    return estate;
}

function numberToString(number){
    number=number.toString();

    let hour;
    let minute;

    if(number.indexOf(".") == 1){
        hour=number.substring(0,1);
        minute=number.substring(2,4);
    }
    else if(number.indexOf(".")== 2){
        hour=number.substring(0,2);
        minute=number.substring(3,5);
    }
    else if(number.indexOf(".")== -1){
        hour=number;
        minute="00";
    }
    if(minute.length < 2){
        minute=minute.concat("0");
    }
    if (hour=="0"){
        hour="12";
    }
    
    minute=parseInt(minute);
    minute=(minute*60)/100;
    minute=Math.round(minute);
    minute=minute.toString();
    
    if(minute.length < 2){
        let cero="0";
        minute=cero.concat(minute);
    }


    number=hour.concat(":"+minute);
    return number;


}

function stringToNumber(time){
    let hour;
    let minute;
    let hours;
    
    if(time.indexOf(":")==1){
        hour=time.substring(0,1);
        hour=parseInt(hour);
        minute=time.substring(2,4);
        minute=parseInt(minute);
        minute=(minute*100)/60;
        minute=minute/100;
        hours=hour+minute;
    }
    else if(time.indexOf(":")==2){
        hour=time.substring(0,2);
        hour=parseInt(hour);
        minute=time.substring(3,5);
        minute=parseInt(minute);
        minute=(minute*100)/60;
        minute=minute/100;
        hours=hour+minute;
        

    }

    
    return hours;


}

let valido=false;

do{
    time = prompt("Hora actual Bogota (hh:mmAm)");
    time=time.trim()
    let hour;
    let minute;
    if(time.indexOf(":")==1){
        hour=time.substring(0,1);
        hour=parseInt(hour);
        minute=time.substring(2,4);
        minute=parseInt(minute);
        estate=time.substring(4,6);
        if(
            typeof hour == "number" && hour>=0 && hour<=12 &&
            typeof minute == "number" && minute >= 0 && minute <= 60 &&
            estate == "PM" || estate == "pm" || estate == "Pm" || estate == "Am" || estate == "am" || estate == "AM"
        ){
            valido = true;
        }
        
    }
    else if(time.indexOf(":")==2){
        hour=time.substring(0,2);
        hour=parseInt(hour);
        minute=time.substring(3,6);
        minute=parseInt(minute);
        estate=time.substring(5,7);
        if(
            typeof hour == "number" && hour>=0 && hour<=12 &&
            typeof minute == "number" && minute >= 0 && minute <= 60 &&
            (estate == "PM" || estate == "pm" || estate == "Pm" || estate == "Am" || estate == "am" || estate == "AM")
        ){
            valido = true;
        }
        
    }
    
    if(valido!= true){
        alert("Valores ingresados no son validos");
    }
    
}while(valido!=true)

function mostrarPaises(paises){
    let text;
    for(pais in paises){
        if(pais == 0){
            text=paises[pais];
        }else{
            text+="/"+paises[pais];
        }
    }
    return text;
}

class Indic{
    constructor(hora,pais,estate){
        this.hora=hora;
        this.pais=pais;
        this.estate=estate;
    }

    show(){
        this.state();
        let text=`<h2>${numberToString(this.hora)}${this.estate}: </h2><p>${mostrarPaises(this.pais)}</p>`
        return text;
    }

    state(){
        if(this.hora == 12){
            this.estate=changeState(this.estate);
        }else if(this.hora == 24){
            this.hora=this.hora-12;
        }
        else if(this.hora>12 && this.hora<24){
            this.hora=this.hora-12;
            this.estate=changeState(this.estate);
        }
        else if (this.hora<0){
            this.hora=this.hora+12;
            this.estate=changeState(this.estate);
        }
        else if(this.hora>=24){
            this.hora=this.hora-24;
        }
    }

}




let hours = stringToNumber(time);

let menosDiez = new Indic(hours-5,["Alaska"],estate);
let menosOcho = new Indic(hours-3,["Los Angeles","Vancuver"],estate);
let menosSeisMedia = new Indic(hours-1.5,["Denver","Mexico"],estate);
let menosSeis = new Indic(hours-1,["Chicago","Guatemala"],estate);
let menosCincoMedia =new Indic(hours-.5,["Cuba","Nicaragua","Costa Rica"],estate);
let menosCinco = new Indic(hours,["Bogota","New York","Washinton","Peru","Chile"],estate);
let menosCuatroMedia=new Indic(hours+.5,["Venezuela","Bolivia","Argentina"],estate);
let menosCuatro=new Indic(hours+1,["Paraguay","Uruguay"],estate);
let menosTres=new Indic(hours+2,["Groenlandia","Brazil"],estate);
let cero=new Indic(hours+5,["Reino Unido","Fracia","España","Algeria","Ghana"],estate);
let ceroMedia=new Indic(hours+5.5,["Noruega","Alemania","Nigeria"],estate);
let uno=new Indic(hours+6,["Italia","Libia","Angola",],estate);
let dos = new Indic(hours+7,["Ucrania","Turkia","Egipto"],estate);
let tres = new Indic(hours+8,["Rusia","Iraq","Arabia Saudita"],estate);
let cuatro=new Indic(hours+9,["Iran","Dubai",],estate);
let cinco=new Indic(hours+10,["India"],estate);
let siete=new Indic(hours+12,["Mongolia","Malasia"],estate);
let ocho = new Indic(hours+13,["China","Taiwan"],estate);
let nueve=new Indic(hours+14,["Japon"],estate);


let iter = [];

iter[0]=Object.create(menosDiez);
iter[1]=Object.create(menosOcho);
iter[2]=Object.create(menosSeisMedia);
iter[3]=Object.create(menosSeis);
iter[4]=Object.create(menosCincoMedia);
iter[5]=Object.create(menosCinco);
iter[6]=Object.create(menosCuatroMedia);
iter[7]=Object.create(menosCuatro);
iter[8]=Object.create(menosTres);
iter[9]=Object.create(cero);
iter[10]=Object.create(ceroMedia);
iter[11]=Object.create(uno);
iter[12]=Object.create(dos);
iter[13]=Object.create(tres);
iter[14]=Object.create(cuatro);
iter[15]=Object.create(cinco);
iter[16]=Object.create(siete);
iter[17]=Object.create(ocho);
iter[18]=Object.create(nueve);


let contenedor=document.querySelector(".contenedor");
let title=`<h1 class="title">Cuando en Colombia son las ${numberToString(menosCinco.hora)}${cinco.estate}, en el resto de paises es:</h1>`;
contenedor.innerHTML=title;
for(let i=0;i<18;i++){
    let div=document.createElement("DIV");
    div.classList="items";
    text = iter[i].show();
    div.innerHTML=text;
    contenedor.appendChild(div);
}



