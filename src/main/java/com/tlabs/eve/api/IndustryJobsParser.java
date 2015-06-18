package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

public class IndustryJobsParser extends EveAPIParser<IndustryJobsResponse> {

    public IndustryJobsParser() {
        super(IndustryJobsResponse.class);
    }
/*
<?xml version='1.0' encoding='UTF-8'?>
<eveapi version="2">
  <currentTime>2014-09-30 21:27:43</currentTime>
  <result>
    <rowset name="jobs" key="jobID" columns="jobID,installerID,installerName,facilityID,solarSystemID,solarSystemName,stationID,activityID,blueprintID,blueprintTypeID,blueprintTypeName,blueprintLocationID,outputLocationID,runs,cost,teamID,licensedRuns,probability,productTypeID,productTypeName,status,timeInSeconds,startDate,endDate,pauseDate,completedDate,completedCharacterID">
      <row
      jobID="240423064"
      installerID="1536117750"
      installerName="Syna Anima"
      facilityID="61000334"
      solarSystemID="30003762"
      solarSystemName="DNR-7M"
      stationID="61000334"
      activityID="1"
      blueprintID="1005794456726"
      blueprintTypeID="4315"
      blueprintTypeName="Amarr Fuel Block Blueprint"
      blueprintLocationID="1988940859"
      outputLocationID="1988940859"
      runs="1000"
      cost="3657036.00"
      teamID="0"
      licensedRuns="200"
      probability="1"
      productTypeID="0"
      productTypeName=""
      status="1"
      timeInSeconds="342720"
      startDate="2014-09-27 15:46:48"
      endDate="2014-10-01 14:58:48"
      pauseDate="0001-01-01 00:00:00"
      completedDate="0001-01-01 00:00:00"
      completedCharacterID="0" />
    </rowset>
  </result>
  <cachedUntil>2014-09-30 21:32:26</cachedUntil>
</eveapi>*/
    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", IndustryJob.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addJob"));
    }
}
