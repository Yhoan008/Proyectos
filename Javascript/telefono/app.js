const todo = document.querySelector("*");
const body = document.querySelector("body");
const container = document.querySelector(".circles");
const circles = document.querySelectorAll(".circle div");
const text=document.querySelector(".text");
const call = document.querySelector(".call");
const kill = document.querySelector(".kill");

let ancho= window.innerWidth/2;
let alto=window.innerHeight/2;



const sacarAngulo=(x,y)=>{
    let angulo=Math.atan(x/y);
    
    angulo=angulo*(180/Math.PI);
    
    if(x>=0 && y>=0){
        angulo=90-angulo;
    }else if(x <= 0 && y >= 0){
        angulo=90-angulo;
    }else if(x <= 0 && y <= 0){
        angulo=180+(90-angulo);
    }else if(x >= 0 && y <=0){
        angulo=180+(90-angulo);
    }

    angulo=Math.round(angulo);

    return angulo;
}

const getNumber=(a)=>{
    
    let number;

    if(a <= 281 && a>=259){
        number=9;
    }else if(a <= 251 && a>=229){
        number = 8;
    }else if(a <= 221 && a>=199){
        number=7;
    }else if(a <= 191 && a>=169){
        number=6;
    }else if(a <= 162 && a>=138){
        number=5;
    }else if(a <= 131 && a>=109){
        number=4;
    }else if(a <= 102 && a>=79){
        number=3;
    }else if(a <= 72 && a>=48){
        number=2;
    }else if(a <= 42 && a>=18){
        number=1;
    }else if((a <= 11 && a>=0)||(a <= 360 && a>=349)){
        number=0;
    }else{
        alert("numero no entendido, intenta nuevamente");
    }
    let stringnumber=number.toString();
    return stringnumber;
}

let marcacion="";

circles.forEach(circle=>{
    circle.addEventListener('click',click=(click)=>{
        let initX=click.pageX-ancho;
        let initY=alto-click.pageY;
        
        let initAng=sacarAngulo(initX,initY);
        
        container.style.transition="0s";
        
        let dif=0;
        body.addEventListener("mousemove",detectarMouse=(move)=>{

            let distX=move.pageX-ancho;
            let distY=alto-move.pageY;

            let ang=sacarAngulo(distX,distY);
            


            if((ang <= (initAng+5)) && (ang<=281 && ang>=0)){
                dif=initAng-ang;
                container.style.rotate=`${dif}deg`;
            }else if(ang <360 && ang >330){
                let postdif=dif+(360-ang);
                console.log(postdif);
                container.style.rotate=`${postdif}deg`;
            }else if(ang<330 && ang>300){
                container.style.transition="1s";
                container.style.rotate=`${0}deg`;
                marcacion=marcacion.concat(getNumber(initAng))
                text.innerHTML=`<h2>${marcacion}</h2>`
                circle.removeEventListener("click",click);
                body.removeEventListener("mousemove",detectarMouse)
            }

        })
    })
})


call.addEventListener('click',()=>{
    alert("llamando");
    marcacion="";
    text.innerHTML='';
})

kill.addEventListener('click',()=>{
    marcacion="";
    text.innerHTML='';
})