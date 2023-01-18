import React from "react";
import styled, { createGlobalStyle } from 'styled-components'


export default class Clock extends React.Component{

    render(){
        const Global = createGlobalStyle`
            body{
                background-color: #012030;
                height:100vh;
                display: flex;
                justify-content: center;
                align-items:center;
            }
        `
        const Container = styled.div`
            position: relative;
            width: 400px;
            height:400px;
            border-radius: 50%;
            background-color: #13678A;
            box-shadow: inset 0px 0px 20px 5px #012030;
            display: flex;
            justify-content: center;
            align-items:center;
        `
        const ContainerRings = styled.div`
            position:absolute;
            width: 300px;
            height:300px;
            display: flex;
            justify-content: center;
            align-items:center;
        `
        
        return <>
            <Global/>
            <Container>
                <Span number={12} deg="0" />
                <Span number={1} deg="30" />
                <Span number={2} deg="60" />
                <Span number={3} deg="90" />
                <Span number={4} deg="120" />
                <Span number={5} deg="150" />
                <Span number={6} deg="180" />
                <Span number={7} deg="210" />
                <Span number={8} deg="240" />
                <Span number={9} deg="270" />
                <Span number={10} deg="300" />
                <Span number={11} deg="330" />
                <ContainerRings>
                    <Agujas color="#D96941" range={80} rotate={{
                        rotation : function(){return new Date().getHours()*30 }
                    }}/>
                    <Agujas color="#2E5902" range={65} rotate={{
                        rotation : function(){return new Date().getMinutes()*6}
                    }}/>
                    <Agujas color="#A62B1F" range={50} rotate={{
                        rotation : function(){return new Date().getSeconds()*6}
                    }}/>
                </ContainerRings>

            </Container>
            
        </>
    }
}

class Agujas extends React.Component{
    
    constructor(props){
        super()
        this.state = {
            rotate : props.rotate.rotation
        }
    }

    componentDidMount(){
        setInterval(()=>{
            this.setState({rotate:this.props.rotate.rotation})
        },1000)
    }

    render(){

        const Containe = styled.div`
            position:absolute;
            border-radius:50%;
            width:${this.props.range}%;
            height:${this.props.range}%;
            border:2px solid gray;
            display: flex;
            justify-content: center;
            transform : rotate(${this.state.rotate}deg);
        `
        const Linear = styled.div`
            position: relative;
            width:4px;
            height: ${100-this.props.range}%;
            background-color: ${this.props.color};
            align-self: center;
            bottom: ${(100-this.props.range)/2}%;
        `
        const Point = styled.div`
            position: absolute;
            top:-5px;
            height: 10px;
            width:10px;
            background-color: ${this.props.color};
            border-radius: 50%;
            box-shadow: 0 0 10px 2px ${this.props.color};
        `

        return(
            <Containe>
                <Linear/>
                <Point/>
            </Containe>
        )
    }
}


function Span(props) {
  
    const Div = styled.div`
        position: absolute;
        width:100%;
        height:100%;
        display: flex;
        justify-content: center;
        align-items:top;
        transform : rotate(${props.deg}deg);
    `;

    const Span = styled.div`
        position: relative;
        height: 40px;
        top:20px;
        font-size:2em;
        font-weight: 700;
        transform : rotate(${-props.deg}deg);
    `;

    return (
        <Div>
            <Span>{ props.number }</Span>
        </Div>
    );
}