
// setIntervale(function,intervale) = Es una funcion que se ejecutara repetidamente cada cierto tiempo
// Los parametros son :
// Funtion : La funcion que se estara ejecutando en tiempo real
// Intervale : El tiempo entre cada intervalo, dada en milisegundos 
setInterval(() => {
    let hour = document.getElementById("hour");
    let minute = document.getElementById("minute");
    let second = document.getElementById("second");
    let ampm = document.getElementById("ampm");

    let hh = document.getElementById("hh");
    let mm = document.getElementById("mm");
    let ss = document.getElementById("ss");

    let hor_point = document.querySelector(".hor-point");
    let min_point = document.querySelector(".min-point");
    let sec_point = document.querySelector(".sec-point");
    
    let h=new Date().getHours();
    let m=new Date().getMinutes();
    let s=new Date().getSeconds();

    //Otra forma de hacer condicionales 
    // Si h >= 12  es true, retorna el primer valor ("AM"), pero si es false retorna el segundo valor ("PM")
    let ap = h >= 12 ? "PM" : "AM";

    //Conversion de formato
    h= h >= 12 ? h-12 : h ;

    //Agregar ceros 
    h= (h < 10) ? "0" + h : h;
    m= (m < 10) ? "0" + m : m;
    s= (s < 10) ? "0" + s : s;

    
    hour.innerHTML=h;
    minute.innerHTML=m;
    second.innerHTML=s;
    ampm.innerHTML=ap;

    hh.style.strokeDashoffset=440-(440*h/12);
    mm.style.strokeDashoffset=440-(440*m/60);
    ss.style.strokeDashoffset=440-(440*s/60);


    hor_point.style.transform=`rotate(${h*30}deg)`
    // 12h => 360deg      360/12 = 30
    min_point.style.transform=`rotate(${m*6}deg)`
    // 60mm => 360deg      360/60 = 6
    sec_point.style.transform=`rotate(${s*6}deg)`
    // 60seg => 360deg      360/60 = 6



});



