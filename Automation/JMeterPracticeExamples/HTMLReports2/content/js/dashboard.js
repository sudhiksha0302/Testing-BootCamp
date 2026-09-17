/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 57.519788918205805, "KoPercent": 42.480211081794195};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.18997361477572558, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.0, 500, 1500, "Makeup - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "SweetTooth - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Corporate - HTTP Request-1"], "isController": false}, {"data": [0.0, 500, 1500, "Dining - HTTP Request-1"], "isController": false}, {"data": [0.45454545454545453, 500, 1500, "Corporate - HTTP Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "NykaaLuxe - HTTP Request-1"], "isController": false}, {"data": [0.0, 500, 1500, "Dining - HTTP Request-0"], "isController": false}, {"data": [1.0, 500, 1500, "NykaaLuxe - HTTP Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "Women - HTTP Request"], "isController": false}, {"data": [0.25, 500, 1500, "Support -  Request"], "isController": false}, {"data": [0.6071428571428571, 500, 1500, "Support -  Request-1"], "isController": false}, {"data": [0.39285714285714285, 500, 1500, "Support -  Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "Corporate - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "NykaaLuxe - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Shampoo - HTTP Request"], "isController": false}, {"data": [0.375, 500, 1500, "Restaurants - HTTP Request-1"], "isController": false}, {"data": [0.0, 500, 1500, "Skin- HTTP Request-1"], "isController": false}, {"data": [1.0, 500, 1500, "Skin- HTTP Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "Makeup - HTTP Request-1"], "isController": false}, {"data": [0.25, 500, 1500, "Restaurants - HTTP Request-0"], "isController": false}, {"data": [0.5, 500, 1500, "Makeup - HTTP Request-0"], "isController": false}, {"data": [0.9, 500, 1500, "FreshFruits - HTTP Request-1"], "isController": false}, {"data": [0.65, 500, 1500, "FreshFruits - HTTP Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "Dining - HTTP Request"], "isController": false}, {"data": [0.5357142857142857, 500, 1500, "Offers - HTTP Request-0"], "isController": false}, {"data": [0.17857142857142858, 500, 1500, "Offers - HTTP Request-1"], "isController": false}, {"data": [0.0, 500, 1500, "Multivitamins - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Multivitamins - HTTP Request-1"], "isController": false}, {"data": [1.0, 500, 1500, "Multivitamins - HTTP Request-0"], "isController": false}, {"data": [0.0, 500, 1500, "DailyEssentials - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "PetCare - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "PersonalCare - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Skin- HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "FreshFruits - HTTP Request"], "isController": false}, {"data": [0.0, 500, 1500, "Shampoo - HTTP Request-1"], "isController": false}, {"data": [0.0, 500, 1500, "Snacks - HTTP Request"], "isController": false}, {"data": [0.03571428571428571, 500, 1500, "Offers - HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Shampoo - HTTP Request-0"], "isController": false}, {"data": [0.075, 500, 1500, "Restaurants - HTTP Request"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 379, 161, 42.480211081794195, 2490.5013192612123, 14, 29053, 1253.0, 6189.0, 8109.0, 24324.999999999967, 11.509611588569346, 3312.381759097224, 1.8503945040845455], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["Makeup - HTTP Request", 1, 1, 100.0, 1889.0, 1889, 1889, 1889.0, 1889.0, 1889.0, 1889.0, 0.5293806246691372, 0.6441486897829539, 0.15095619375330863], "isController": false}, {"data": ["SweetTooth - HTTP Request", 30, 30, 100.0, 1144.3000000000002, 222, 3740, 916.5, 2195.8, 3392.9499999999994, 3740.0, 1.2990949638418567, 713.6082565604296, 0.16746146018273936], "isController": false}, {"data": ["Corporate - HTTP Request-1", 11, 0, 0.0, 4162.454545454544, 2385, 8577, 3307.0, 8122.200000000002, 8577.0, 8577.0, 0.5183544602045144, 179.8240834550681, 0.06681912963573819], "isController": false}, {"data": ["Dining - HTTP Request-1", 2, 0, 0.0, 22367.0, 20958, 23776, 22367.0, 23776.0, 23776.0, 23776.0, 0.08411843876177658, 79.38275138269684, 0.010679098670928668], "isController": false}, {"data": ["Corporate - HTTP Request-0", 11, 0, 0.0, 2498.4545454545455, 127, 6621, 1171.0, 6620.6, 6621.0, 6621.0, 0.5708354955889985, 0.19176504929942917, 0.06912461079398029], "isController": false}, {"data": ["NykaaLuxe - HTTP Request-1", 1, 1, 100.0, 8109.0, 8109, 8109, 8109.0, 8109.0, 8109.0, 8109.0, 0.12331976815883587, 0.09959516432359107, 0.01686012455296584], "isController": false}, {"data": ["Dining - HTTP Request-0", 2, 0, 0.0, 5510.5, 5275, 5746, 5510.5, 5746.0, 5746.0, 5746.0, 0.3480682213713888, 0.11624934737208492, 0.04146906543682562], "isController": false}, {"data": ["NykaaLuxe - HTTP Request-0", 1, 0, 0.0, 355.0, 355, 355, 355.0, 355.0, 355.0, 355.0, 2.8169014084507045, 1.0865977112676057, 0.3741197183098592], "isController": false}, {"data": ["Women - HTTP Request", 1, 1, 100.0, 26521.0, 26521, 26521, 26521.0, 26521.0, 26521.0, 26521.0, 0.03770596885486972, 0.11639508549828438, 0.0], "isController": false}, {"data": ["Support -  Request", 14, 0, 0.0, 3378.571428571429, 466, 8856, 2556.5, 7638.5, 8856.0, 8856.0, 0.5840877800492302, 50.64798052953815, 0.1425995556760816], "isController": false}, {"data": ["Support -  Request-1", 14, 0, 0.0, 1186.2857142857147, 161, 4650, 678.5, 3792.0, 4650.0, 4650.0, 0.6465019625952436, 55.84480886342646, 0.08144409489725236], "isController": false}, {"data": ["Support -  Request-0", 14, 0, 0.0, 2191.642857142857, 139, 5989, 1966.0, 5607.5, 5989.0, 5989.0, 0.6127719175384077, 0.2040578358208955, 0.07240761916225325], "isController": false}, {"data": ["Corporate - HTTP Request", 11, 0, 0.0, 6661.454545454547, 2896, 12621, 7106.0, 11935.600000000002, 12621.0, 12621.0, 0.49688318727979036, 172.54233388291624, 0.12422079681994759], "isController": false}, {"data": ["NykaaLuxe - HTTP Request", 1, 1, 100.0, 8465.0, 8465, 8465, 8465.0, 8465.0, 8465.0, 8465.0, 0.11813349084465447, 0.14097570880094507, 0.03184066745422327], "isController": false}, {"data": ["Shampoo - HTTP Request", 1, 1, 100.0, 4322.0, 4322, 4322, 4322.0, 4322.0, 4322.0, 4322.0, 0.23137436372049977, 0.2837951180009255, 0.07659756767700139], "isController": false}, {"data": ["Restaurants - HTTP Request-1", 20, 0, 0.0, 1365.85, 260, 3120, 1223.5, 2319.5, 3080.3999999999996, 3120.0, 0.6754931099702783, 59.6149715659619, 0.08773494494731153], "isController": false}, {"data": ["Skin- HTTP Request-1", 1, 1, 100.0, 2202.0, 2202, 2202, 2202.0, 2202.0, 2202.0, 2202.0, 0.45413260672116257, 0.3738611205722071, 0.06563635331516803], "isController": false}, {"data": ["Skin- HTTP Request-0", 1, 0, 0.0, 199.0, 199, 199, 199.0, 199.0, 199.0, 199.0, 5.025125628140704, 1.9776617462311556, 0.7066582914572864], "isController": false}, {"data": ["Makeup - HTTP Request-1", 1, 1, 100.0, 675.0, 675, 675, 675.0, 675.0, 675.0, 675.0, 1.4814814814814814, 1.2196180555555556, 0.21412037037037035], "isController": false}, {"data": ["Restaurants - HTTP Request-0", 20, 0, 0.0, 2946.6500000000005, 222, 10601, 1756.5, 6620.9, 10401.999999999996, 10601.0, 0.6674899042151987, 0.22488673530687847, 0.08148070119814438], "isController": false}, {"data": ["Makeup - HTTP Request-0", 1, 0, 0.0, 1210.0, 1210, 1210, 1210.0, 1210.0, 1210.0, 1210.0, 0.8264462809917356, 0.3252518078512397, 0.11621900826446281], "isController": false}, {"data": ["FreshFruits - HTTP Request-1", 10, 0, 0.0, 191.3, 14, 542, 65.0, 542.0, 542.0, 542.0, 0.8533151292772421, 0.6499861336291493, 0.146663537844526], "isController": false}, {"data": ["FreshFruits - HTTP Request-0", 10, 0, 0.0, 1003.6, 136, 3842, 740.5, 3613.2000000000007, 3842.0, 3842.0, 0.7711289327575571, 0.2921855721776681, 0.1265133405305367], "isController": false}, {"data": ["Dining - HTTP Request", 2, 0, 0.0, 27879.5, 26706, 29053, 27879.5, 29053.0, 29053.0, 29053.0, 0.06774379297496867, 63.952588342140025, 0.016671324052433698], "isController": false}, {"data": ["Offers - HTTP Request-0", 14, 0, 0.0, 1519.3571428571427, 111, 6531, 753.0, 5104.5, 6531.0, 6531.0, 0.6159260888693356, 0.2093186317641883, 0.07699076110866696], "isController": false}, {"data": ["Offers - HTTP Request-1", 14, 0, 0.0, 2962.0714285714284, 808, 6329, 2326.0, 5949.0, 6329.0, 6329.0, 0.5697310055752248, 188.04584649564563, 0.07566739917795955], "isController": false}, {"data": ["Multivitamins - HTTP Request", 1, 1, 100.0, 8822.0, 8822, 8822, 8822.0, 8822.0, 8822.0, 8822.0, 0.11335298118340512, 0.14124844139650874, 0.03564419916118794], "isController": false}, {"data": ["Multivitamins - HTTP Request-1", 1, 1, 100.0, 8371.0, 8371, 8371, 8371.0, 8371.0, 8371.0, 8371.0, 0.11946004061641381, 0.10009444809461235, 0.01901561193405806], "isController": false}, {"data": ["Multivitamins - HTTP Request-0", 1, 0, 0.0, 451.0, 451, 451, 451.0, 451.0, 451.0, 451.0, 2.2172949002217295, 0.9051067073170731, 0.34428700110864746], "isController": false}, {"data": ["DailyEssentials - HTTP Request", 30, 30, 100.0, 1224.0333333333333, 370, 3143, 1000.5, 2785.400000000001, 3099.0, 3143.0, 1.3152702880441929, 722.4952663970362, 0.21963986255425488], "isController": false}, {"data": ["PetCare - HTTP Request", 30, 30, 100.0, 1218.9, 344, 4163, 940.5, 2774.7000000000016, 3572.8499999999995, 4163.0, 1.3267291703520254, 728.7895220181763, 0.1710236821156908], "isController": false}, {"data": ["PersonalCare - HTTP Request", 30, 30, 100.0, 1327.8000000000002, 248, 3277, 1195.0, 2821.000000000002, 3127.95, 3277.0, 1.3097005151488694, 719.4346084268315, 0.17138659084955907], "isController": false}, {"data": ["Skin- HTTP Request", 1, 1, 100.0, 2401.0, 2401, 2401, 2401.0, 2401.0, 2401.0, 2401.0, 0.41649312786339027, 0.5067875364431488, 0.11876561849229489], "isController": false}, {"data": ["FreshFruits - HTTP Request", 10, 0, 0.0, 1195.1999999999998, 161, 3963, 982.0, 3748.300000000001, 3963.0, 3963.0, 0.7696451935657662, 0.877876548910952, 0.2585526822134996], "isController": false}, {"data": ["Shampoo - HTTP Request-1", 1, 1, 100.0, 4231.0, 4231, 4231, 4231.0, 4231.0, 4231.0, 4231.0, 0.2363507445048452, 0.19572796029307493, 0.03531412491136847], "isController": false}, {"data": ["Snacks - HTTP Request", 30, 30, 100.0, 1452.6000000000004, 331, 4077, 1090.0, 2699.7000000000007, 3867.45, 4077.0, 1.2875536480686696, 707.2689780042919, 0.1697458422746781], "isController": false}, {"data": ["Offers - HTTP Request", 14, 0, 0.0, 4481.714285714286, 996, 10007, 3716.0, 9579.0, 10007.0, 10007.0, 0.5600672080649678, 185.0465415224827, 0.1443923270792495], "isController": false}, {"data": ["Shampoo - HTTP Request-0", 1, 0, 0.0, 91.0, 91, 91, 91.0, 91.0, 91.0, 91.0, 10.989010989010989, 4.378434065934066, 1.9960508241758241], "isController": false}, {"data": ["Restaurants - HTTP Request", 20, 0, 0.0, 4313.55, 900, 13726, 3591.5, 6972.0, 13388.799999999996, 13726.0, 0.6412517233640065, 56.80907882186027, 0.16156537561319695], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["403/Forbidden", 160, 99.37888198757764, 42.21635883905013], "isController": false}, {"data": ["Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 1, 0.6211180124223602, 0.2638522427440633], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 379, 161, "403/Forbidden", 160, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 1, "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["Makeup - HTTP Request", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["SweetTooth - HTTP Request", 30, 30, "403/Forbidden", 30, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["NykaaLuxe - HTTP Request-1", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["Women - HTTP Request", 1, 1, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["NykaaLuxe - HTTP Request", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["Shampoo - HTTP Request", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["Skin- HTTP Request-1", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["Makeup - HTTP Request-1", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["Multivitamins - HTTP Request", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["Multivitamins - HTTP Request-1", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["DailyEssentials - HTTP Request", 30, 30, "403/Forbidden", 30, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["PetCare - HTTP Request", 30, 30, "403/Forbidden", 30, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["PersonalCare - HTTP Request", 30, 30, "403/Forbidden", 30, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["Skin- HTTP Request", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["Shampoo - HTTP Request-1", 1, 1, "403/Forbidden", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["Snacks - HTTP Request", 30, 30, "403/Forbidden", 30, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
