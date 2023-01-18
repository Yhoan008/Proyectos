const cajas = document.querySelectorAll('body div');
const audios = document.querySelectorAll('body div audio');


for (let i = 0; i < 12; i++) {
    cajas[i].addEventListener('click',()=>{
        
        for (let j = 0; j < 12; j++) {

            if(cajas[j].classList.contains('active') && i === j){

                audios[i].pause();

            }else if(cajas[j].classList.contains('active')){

                cajas[j].classList.remove('active');
                audios[j].currentTime =0;
                audios[j].pause();

            }else{

                cajas[i].classList.add('active');
                audios[i].play();

            }
        }

    })
    
}
