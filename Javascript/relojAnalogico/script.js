
setInterval(()=>{
    let hh = document.getElementById("hh");
    let mm = document.getElementById("mm");
    let ss = document.getElementById("ss");
    let ampm = document.getElementById("hour_ampm")

    let circle_hh = document.getElementById("circle_hh");
    let circle_mm = document.getElementById("circle_mm");
    let circle_ss = document.getElementById("circle_ss");
    
    let h = new Date().getHours();
    let m = new Date().getMinutes();
    let s = new Date().getSeconds();
    

    h= (h < 10) ? "0" + h : h;
    m= (m < 10) ? "0" + m : m;
    s= (s < 10) ? "0" + s : s;

    let ap= (h>=12) ? "pm" : "am";
    
    h = (h>12) ? h-12 : h;
    
    
    hh.innerHTML=h;
    mm.innerHTML=m;
    ss.innerHTML=s;
    ampm.innerHTML=ap;


    circle_hh.style.transform=`rotate(${h*30}deg)`;
    circle_mm.style.transform=`rotate(${m*6}deg)`;
    circle_ss.style.transform=`rotate(${s*6}deg)`;



});




