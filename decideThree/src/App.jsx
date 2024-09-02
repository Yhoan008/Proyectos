import React, { useEffect, useState } from "react";

import question from "./assets/quest.png";
import burger from "./assets/burger.png";
import clock from "./assets/clock.png";
import back from "./assets/back.png";

// RECUERDA QUE PROCESS ES UN OBJETO {}
import process from "./process.json";

export default function App() {
  return (
    <div className="w-full h-[100vh] bg-[#464646] flex justify-center items-center ">
      <Container />
    </div>
  );
}

function Container() {
  let instanceDefault = {
    question: "Error! Value undefined",
    type: "undefined",
    options: ["undefined"],
    product: ["undefined"],
    descrip: "undefined",
    help: "undefined",
  };

  const [instance, setInstance] = useState(process);
  const [history, setHistory] = useState([]);
  const [helpActive, setHelp] = useState(false);

  useEffect(() => {
    if (instance === undefined || Object.keys(instance).length === 0) {
      console.error("La instancia del arbol esta vacia o no existe");
      setInstance(instanceDefault);
    }
  }, [instance]);

  return (
    <div className="flex flex-col p-4 w-[600px]  bg-gradient-to-br from-[#070b2d] to-[#4125c8] rounded-xl flex-wrap ">
      <div className="flex justify-between h-14 items-center ">
        <div className=" flex flex-row gap-3 w-[70%] ">
          <h1 className=" font-bold text-xl text-white">
            {instance?.question || ""}
          </h1>
          {instance?.help ? (
            //Aca hace falta aplicar el efecto onhover
            <div
              className="w-5 h-5 rounded-full relative"
              onMouseEnter={() => {
                setHelp(true);
              }}
              onMouseLeave={() => {
                setHelp(false);
              }}
            >
              {helpActive ? (
                <div className="absolute w-[300px] text-white bg-slate-700 ml-[150%] p-2 rounded-md ">
                  {instance.help}
                </div>
              ) : (
                <></>
              )}

              <img src={question} alt="QuestionIcon" />
            </div>
          ) : (
            ""
          )}
        </div>
        <div className=" self-start flex gap-4 p-1 rounded-xl bg-[rgba(99,99,99,0.5)] ">
          <div className="w-5 h-5 cursor-pointer  ">
            <img src={burger} alt="Menu icon" />
          </div>
          <div className="w-5 h-5 cursor-pointer  ">
            <img src={clock} alt="Menu icon" />
          </div>
          <div
            className="w-5 h-5 cursor-pointer  "
            onClick={() => {
              if (history.length < 1) {
                console.log("limite alcanzado");
              } else {
                setInstance(() => {
                  setHistory(history.slice(0, -1));
                  return history[history.length - 1];
                });
              }
            }}
          >
            <img src={back} alt="Menu icon" />
          </div>
        </div>
      </div>
      <div className="w-full flex-grow">
        {(instance?.type || instanceDefault.type) === "multitask" ? (
          <select
            name="options "
            className="py-2 px-5  mt-5 rounded font-bold text-xl bg-[#011059] text-[#418cf1] "
            onChange={(event) => {
              setHistory([...history, instance]);
              setInstance(
                (prev) => prev.product[event.target.selectedIndex - 1]
              );
            }}
          >
            <option value="null">Selecciona una opción</option>
            {instance.options.map((index, id) => (
              <option key={id} value={`${index}`}>
                {index}
              </option>
            ))}
          </select>
        ) : (instance?.type || instanceDefault.type) === "bitask" ? (
          <div className="flex justify-start gap-10 px-2 mt-5  text-xl font-bold ">
            <button
              className="border-2 border-white hover:border-[#011059] rounded-xl px-10 hover:bg-[#011059] py-2 text-white hover:text-[#418cf1] transition-colors "
              onClick={() => {
                setHistory([...history, instance]);
                setInstance((prev) => prev.product[0]);
              }}
            >
              SI
            </button>
            <button
              className="border-2 border-white hover:border-[#011059] rounded-xl px-10 hover:bg-[#011059] py-2 text-white hover:text-[#418cf1] transition-colors "
              onClick={() => {
                setHistory([...history, instance]);
                setInstance((prev) => prev.product[1]);
              }}
            >
              NO
            </button>
          </div>
        ) : (instance?.type || instanceDefault.type) === "solution" ? (
          <div className=" text-white h-full ">
            solucion: {instance.product[0]}
          </div>
        ) : (instance?.type || instanceDefault.type) === "undefined" ? (
          ""
        ) : (
          ""
        )}
      </div>
    </div>
  );
}
