import React, { useEffect, useState } from "react";
import axios from "axios";

function Overview() {
  const token = sessionStorage.getItem("token");
  const [overview, setOverview] = useState({
    allSubtask: 0,
    beginningBudget: 0,
    budgetSpend: 0,
    guestsAccepted: 0,
    guestsInvited: 0,
    subtaskDone: 0,
    weddingDate: "",
  });

  useEffect(() => {
    getOverview();
  }, []);

  async function getOverview() {
    try {
      const response = await axios.get("/overview", {
        headers: {
          Authorization: `Bearer ${token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
      const data = response.data;
      setOverview(data);
    } catch (error) {
      console.error("Error fetching overview:", error);
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
