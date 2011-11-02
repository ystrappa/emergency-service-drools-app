[condition][]The average pulse is {p} in the last {s} seconds=Number(doubleValue == {p} ) from accumulate( PulseEvent(processed == false, $pulse: value) over window:time({s}s) from entry-point "patientHeartbeats",	average($pulse))
[condition][]The pulse is greater than {p}/{s} seconds=ArrayList(size > {p} ) from collect( PulseEvent( processed == false, $pulse: value) over window:time({s}s) from entry-point "patientHeartbeats")
[consequence][]Send Alert: "{message}"=MessageFactory.sendMessage(new PatientMonitorAlertMessage(emergencyId, vehicleId, "{message}", new java.util.Date()));