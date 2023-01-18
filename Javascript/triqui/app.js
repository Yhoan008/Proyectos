let cajas=document.querySelectorAll(".container div");
let reset=document.querySelector(".btn");
let alert=document.querySelector(".alert");
let alert_btn=document.querySelector(".alert button");

let jugador=1;
let active=[];

for(let i = 0; i < cajas.length; i++){
    active[i]=false;
}

for (let i = 0; i < cajas.length; i++) {
    cajas[i].addEventListener('mouseenter',()=>{
        mostrarBtn(cajas[i],jugador,active[i]);
    });
    cajas[i].addEventListener('mouseleave',()=>{
        quitarBtn(cajas[i],active[i]);
    });
    cajas[i].addEventListener('click',()=>{
        active[i]=true;
        mostrarBtn(cajas[i],jugador,active[i]);
        comprobar(jugador,i);
        if(jugador==1)jugador=2;
        else jugador=1;
    })
    
}



reset.addEventListener('click',()=>{
    reiniciar();
})


alert_btn.addEventListener('click',()=>{
    alert.style.display='none';
    alert.innerHTML='';
    alert.appendChild(alert_btn);
    reiniciar();
})


let x=[];
let o=[];

function reiniciar(){
    for (let i = 0; i < cajas.length; i++) {
        cajas[i].innerHTML='';
        active[i]=false;
    }
    let a=[];
    x=x.slice(0,0);
    o=o.slice(0,0);
    jugador=1;
}

function comprobar(jugador,i){
    if(jugador==1){
        x.push(i);
        if(x.length>=3)ganar(x,jugador);
    }else if(jugador==2){
        o.push(i);
        if(o.length>=3) ganar(o,jugador);
    }
}

function ganar(a,jugador){
    console.log(a);
    if(
        (
            a.indexOf(0)!= -1 && 
            a.indexOf(1)!= -1 && 
            a.indexOf(2)!= -1
        ) ||
        (
            a.indexOf(3)!= -1 && 
            a.indexOf(4)!= -1 && 
            a.indexOf(5)!= -1
        ) ||
        (
            a.indexOf(6)!= -1 && 
            a.indexOf(7)!= -1 && 
            a.indexOf(8)!= -1
        ) ||
        (
            a.indexOf(0)!= -1 && 
            a.indexOf(3)!= -1 && 
            a.indexOf(6)!= -1
        ) ||
        (
            a.indexOf(1)!= -1 && 
            a.indexOf(4)!= -1 && 
            a.indexOf(7)!= -1
        ) ||
        (
            a.indexOf(2)!= -1 && 
            a.indexOf(5)!= -1 && 
            a.indexOf(8)!= -1
        ) ||
        (
            a.indexOf(0)!= -1 && 
            a.indexOf(4)!= -1 && 
            a.indexOf(8)!= -1
        ) ||
        (
            a.indexOf(2)!= -1 && 
            a.indexOf(4)!= -1 && 
            a.indexOf(6)!= -1
        )
    ){
        alert.style.display='flex';
        const resp=document.createElement('h2');
        resp.textContent=`El jugador ${jugador} ha ganado`;
        resp.classList.add("text");
        alert.appendChild(resp);
    }
}

function mostrarBtn(caja,jugador,active){
    if(active==false){
        if(jugador==1){
            caja.innerHTML=`<div class="equis"></div>`;
        }else if(jugador==2){
            caja.innerHTML=`<div class="circle"></div>`;
        }
    }
}

function quitarBtn(e,active){
    if(active!=true){
        e.innerHTML=``;
    }
}