const contador = document.querySelector('.contador');
const cajas = document.querySelectorAll('.caja');


// window.onscroll detecta cuando hay algun cambio en el scroll de la pantalla, cuando lo haya se ejecuta la funcion
window.onscroll = function() {
    var y = window.scrollY;

    // active
    if(y>200){
        cajas[3].style.transform = 'translate(0px)';
    }else{
        cajas[3].style.transform = 'translate(1000px)';
    }
    if(y>435){
        cajas[4].style.transform = 'translate(0px)';
    }else{
        cajas[4].style.transform = 'translate(-1000px)';
    }
    if(y>670){
        cajas[5].style.transform = 'translate(0px)';
    }else{
        cajas[5].style.transform = 'translate(1000px)';
    }
    if(y>905){
        cajas[6].style.transform = 'translate(0px)';
    }else{
        cajas[6].style.transform = 'translate(-1000px)';
    }
    if(y>1140){
        cajas[7].style.transform = 'translate(0px)';
    }else{
        cajas[7].style.transform = 'translate(1000px)';
    }

};


