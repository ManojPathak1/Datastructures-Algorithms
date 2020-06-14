import React, { useState, useEffect } from "react";

function ShowNumberNotifications() {
  const [notificationsNumber, setNotificationsNumber] = useState(0);
  const getNotificationsNumber = async () => {
    const notificationsNumber = await apiServiceNotifications();
    return notificationsNumber;
  };
  useEffect(() => {
    const timeInterval = 5000;
    let timeoutId = null;
    const _getNotifications = () => {
      timeoutId = setTimeout(async () => {
        const notifications = await getNotificationsNumber();
        setNotificationsNumber(notifications);
        timeoutId = setTimeout(_getNotifications, timeInterval);
      }, timeInterval);
    };
    _getNotifications();
    const intervalId = setInterval(getNotificationsNumber, timeInterval);
    return () => clearInterval(intervalId); // At unmounting
  }, []);

  return (
    <div>
      #Number of unread notifications: <span style={{ color: notifications > 0 ? 'red' : '#fff' }}>{notificationsNumber}</span>
    </div>
  );
}

export default ShowNumberNotifications;


const ComponentInstance = ShowNumberNotifications();
function testingForNotificationsColor() {
  const notifications = ComponentInstance.notifications;
  const notificationsSpan = document.querySelector("div > span");
  const colorProperty = notificationsSpan.color;
  return (notifications > 0 && colorProperty === "red") || (notifications === 0 && colorProperty === "#fff");
}


testingForNotificationsColor();