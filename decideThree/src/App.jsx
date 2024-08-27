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
  const [instance, setInstance] = useState(process);
  const [history, setHistory] = useState([]);

  return (
    <div className="flex flex-col p-6 min-w-[600px] bg-[#c799a6] rounded-xl flex-wrap ">
      <div className="flex justify-around h-14 items-center ">
        <div className=" flex flex-row gap-3 w-[70%] ">
          <h1 className=" font-bold text-xl ">{instance.question}</h1>
          <div className="w-5 h-5  rounded-full ">
            <img src={question} alt="QuestionIcon" />
          </div>
        </div>
        <div className=" pl-10 h-10 w-auto self-start flex gap-4 ">
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
      <div className="w-full flex-grow mt-14 ">
        {instance.type === "multitask" ? (
          <select
            name="options "
            className="py-1 px-5 rounded font-bold text-xl  "
            onChange={(event) => {
              console.log(event.target.selectedIndex);
              setHistory([...history, instance]);
              setInstance((prev) => prev.product[event.target.selectedIndex]);
            }}
          >
            {instance.options.map((index, id) => (
              <option key={id} value={`${index}`}>
                {index}
              </option>
            ))}
          </select>
        ) : instance.type === "bitask" ? (
          <div className="flex gap-10 px-2 text-xl font-bold ">
            <button
              className="bg-[#7065f2] w-20 px-3 py-2 rounded "
              onClick={() => {
                setHistory([...history, instance]);
                setInstance((prev) => prev.product[0]);
              }}
            >
              SI
            </button>
            <button
              className="bg-[#7065f2] w-20 px-3 py-2 rounded "
              onClick={() => {
                setHistory([...history, instance]);
                setInstance((prev) => prev.product[1]);
              }}
            >
              NO
            </button>
          </div>
        ) : instance.type === "solution" ? (
          <div>solucion: {instance.product[0]} </div>
        ) : (
          ""
        )}
      </div>
    </div>
  );
}
