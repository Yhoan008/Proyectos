const container = document.querySelector('.container');
const text = document.getElementById('text');

let count = 0;

let hola =setInterval(function(){
    count++;
    text.innerHTML=`${count}%`;
    text.style.filter=`opacity(${100-count}%)`;
    
    container.style.filter=`blur(${(100-count)/10}px)`;

    if(count>=100){
        clearInterval(hola);
    }
},25)
