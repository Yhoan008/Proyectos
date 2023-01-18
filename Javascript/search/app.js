const container = document.querySelector('.container');
const btn = document.getElementById('search');

btn.addEventListener('click',function(event){
    container.classList.toggle('active');
})

