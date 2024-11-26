### Introducing periodic calls and Dashboard
    We want to havce real time update of the intervals of all subsystems
    --> In Main.java add a scheduler each second calling for a Dashboard update
    --> Add a Dashboard class.

## Dashboard Class
    Need to know the subsystems --> registration system
    this will be called periodically and update the dashboard on the defined interval.

## CS_SubsystemBase
    Add abstract updateDashboard() method to force all subsystems to implement it

    