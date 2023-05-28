import React, { useEffect, useState } from "react";
import axiosInstance from "../axios-interceptors";

function Overview() {
 
  const [overview, setOverview] = useState({});

  useEffect(() => {
    getOverview();
  }, []);

  async function getOverview() {

    try{

      const response = await axiosInstance.get("/overview")
      setOverview(response.data);

    }catch(error){

    }

  }

  return (
    <div className="overview">
      <div className="weddingDate">
        <div className="overLabel">Wedding date:</div>
        {overview.weddingDate ? (
          <div className="overInfo">{overview.weddingDate}</div>
        ) : (
          <div className="overInfo">Your wedding date is not set yet.</div>
        )}
      </div>

      <hr />
      <div className="budgett">
        <div className="overLabel">Budget left:</div>
        <div className="overInfo">
          {overview.budgetSpend} / {overview.beginningBudget != null ? overview.beginningBudget : "You didn't set your budget"}
        </div>
      </div>

      <hr />
      <div className="guests">
        <div className="overLabel">Confirmed guests:</div>
        <div className="overInfo">
          {overview.guestsAccepted} / {overview.guestsInvited}
        </div>
      </div>

      <hr />
      <div className="tasks">
        <div className="overLabel">Tasks completed:</div>
        <div className="overInfo">
          {overview.subtaskDone} / {overview.allSubtask}
        </div>
      </div>
    </div>
  );
}

export default Overview;
