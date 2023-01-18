const btnOpen = document.querySelector('.btnOpen');
const btnClose = document.querySelector('.btnClose');
const circle = document.querySelector('.circle');
const container = document.querySelector('.container');
const menu = document.querySelector('.menu');

cambiarEstado = () => {
    container.classList.toggle('active');
    circle.classList.toggle('active');
    menu.classList.toggle('activeMenu');
}

btnOpen.addEventListener('click',function(event){
    cambiarEstado();
})
btnClose.addEventListener('click',function(event){
    cambiarEstado();
})
