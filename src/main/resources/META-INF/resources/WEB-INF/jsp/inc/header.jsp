<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head id="ctl00_Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-16"/>
    <script type="text/javascript">window.NREUM || (NREUM = {});
    NREUM.info = {
        "beacon": "bam.nr-data.net",
        "errorBeacon": "bam.nr-data.net",
        "licenseKey": "5b0b23e467",
        "applicationID": "4749709",
        "transactionName": "YgdSMENQXBdUUhALDVtNcTdhHlMAWFgKTQNWAV8RX0VbClIeBxAHVBZVElJQQQxUUgcNF1sWQ0pQQkIc",
        "queueTime": 0,
        "applicationTime": 52,
        "ttGuid": "ADC6A6D6847AC930",
        "agent": ""
    }</script>
    <script type="text/javascript">window.NREUM || (NREUM = {}), __nr_require = function (e, t, n) {
        function r(n) {
            if (!t[n]) {
                var o = t[n] = {exports: {}};
                e[n][0].call(o.exports, function (t) {
                    var o = e[n][1][t];
                    return r(o || t)
                }, o, o.exports)
            }
            return t[n].exports
        }

        if ("function" == typeof __nr_require)return __nr_require;
        for (var o = 0; o < n.length; o++)r(n[o]);
        return r
    }({
        1: [function (e, t, n) {
            function r(e, t) {
                return function () {
                    o(e, [(new Date).getTime()].concat(a(arguments)), null, t)
                }
            }

            var o = e("handle"), i = e(2), a = e(3);
            "undefined" == typeof window.newrelic && (newrelic = NREUM);
            var u = ["setPageViewName", "setCustomAttribute", "finished", "addToTrace", "inlineHit"], c = ["addPageAction"], f = "api-";
            i(u, function (e, t) {
                newrelic[t] = r(f + t, "api")
            }), i(c, function (e, t) {
                newrelic[t] = r(f + t)
            }), t.exports = newrelic, newrelic.noticeError = function (e) {
                "string" == typeof e && (e = new Error(e)), o("err", [e, (new Date).getTime()])
            }
        }, {}], 2: [function (e, t, n) {
            function r(e, t) {
                var n = [], r = "", i = 0;
                for (r in e)o.call(e, r) && (n[i] = t(r, e[r]), i += 1);
                return n
            }

            var o = Object.prototype.hasOwnProperty;
            t.exports = r
        }, {}], 3: [function (e, t, n) {
            function r(e, t, n) {
                t || (t = 0), "undefined" == typeof n && (n = e ? e.length : 0);
                for (var r = -1, o = n - t || 0, i = Array(0 > o ? 0 : o); ++r < o;)i[r] = e[t + r];
                return i
            }

            t.exports = r
        }, {}], ee: [function (e, t, n) {
            function r() {
            }

            function o(e) {
                function t(e) {
                    return e && e instanceof r ? e : e ? u(e, a, i) : i()
                }

                function n(n, r, o) {
                    e && e(n, r, o);
                    for (var i = t(o), a = l(n), u = a.length, c = 0; u > c; c++)a[c].apply(i, r);
                    var s = f[g[n]];
                    return s && s.push([m, n, r, i]), i
                }

                function p(e, t) {
                    w[e] = l(e).concat(t)
                }

                function l(e) {
                    return w[e] || []
                }

                function d(e) {
                    return s[e] = s[e] || o(n)
                }

                function v(e, t) {
                    c(e, function (e, n) {
                        t = t || "feature", g[n] = t, t in f || (f[t] = [])
                    })
                }

                var w = {}, g = {}, m = {on: p, emit: n, get: d, listeners: l, context: t, buffer: v};
                return m
            }

            function i() {
                return new r
            }

            var a = "nr@context", u = e("gos"), c = e(2), f = {}, s = {}, p = t.exports = o();
            p.backlog = f
        }, {}], gos: [function (e, t, n) {
            function r(e, t, n) {
                if (o.call(e, t))return e[t];
                var r = n();
                if (Object.defineProperty && Object.keys)try {
                    return Object.defineProperty(e, t, {value: r, writable: !0, enumerable: !1}), r
                } catch (i) {
                }
                return e[t] = r, r
            }

            var o = Object.prototype.hasOwnProperty;
            t.exports = r
        }, {}], handle: [function (e, t, n) {
            function r(e, t, n, r) {
                o.buffer([e], r), o.emit(e, t, n)
            }

            var o = e("ee").get("handle");
            t.exports = r, r.ee = o
        }, {}], id: [function (e, t, n) {
            function r(e) {
                var t = typeof e;
                return !e || "object" !== t && "function" !== t ? -1 : e === window ? 0 : a(e, i, function () {
                    return o++
                })
            }

            var o = 1, i = "nr@id", a = e("gos");
            t.exports = r
        }, {}], loader: [function (e, t, n) {
            function r() {
                if (!w++) {
                    var e = v.info = NREUM.info, t = s.getElementsByTagName("script")[0];
                    if (e && e.licenseKey && e.applicationID && t) {
                        c(l, function (t, n) {
                            e[t] || (e[t] = n)
                        });
                        var n = "https" === p.split(":")[0] || e.sslForHttp;
                        v.proto = n ? "https://" : "http://", u("mark", ["onload", a()], null, "api");
                        var r = s.createElement("script");
                        r.src = v.proto + e.agent, t.parentNode.insertBefore(r, t)
                    }
                }
            }

            function o() {
                "complete" === s.readyState && i()
            }

            function i() {
                u("mark", ["domContent", a()], null, "api")
            }

            function a() {
                return (new Date).getTime()
            }

            var u = e("handle"), c = e(2), f = window, s = f.document;
            NREUM.o = {
                ST: setTimeout,
                CT: clearTimeout,
                XHR: f.XMLHttpRequest,
                REQ: f.Request,
                EV: f.Event,
                PR: f.Promise,
                MO: f.MutationObserver
            }, e(1);
            var p = "" + location, l = {
                beacon: "bam.nr-data.net",
                errorBeacon: "bam.nr-data.net",
                agent: "js-agent.newrelic.com/nr-943.min.js"
            }, d = window.XMLHttpRequest && XMLHttpRequest.prototype && XMLHttpRequest.prototype.addEventListener && !/CriOS/.test(navigator.userAgent), v = t.exports = {
                offset: a(),
                origin: p,
                features: {},
                xhrWrappable: d
            };
            s.addEventListener ? (s.addEventListener("DOMContentLoaded", i, !1), f.addEventListener("load", r, !1)) : (s.attachEvent("onreadystatechange", o), f.attachEvent("onload", r)), u("mark", ["firstbyte", a()], null, "api");
            var w = 0
        }, {}]
    }, {}, ["loader"]);</script>
    <title>
        interMark Admin Site
    </title>
    <link href="/stylesheet/style.css" rel="stylesheet" type="text/css"/>
    <link href="/stylesheet/ajaxControls.css" rel="stylesheet" type="text/css"/>
    <link href="/stylesheet/superfish.css" rel="stylesheet" type="text/css"/>
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <script src="/js/jquery.hoverIntent.js" type="text/javascript"></script>
    <script src="/js/superfish.js" type="text/javascript"></script>
    <script src="/js/supersubs.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">
        function StartProgressBar() {
            var myExtender = $find('ProgressBarModalPopupExtender');
            myExtender.show();
            return true;
        }
    </script>
    <script type="text/javascript">

        $(document).ready(function () {
            $("ul.sf-menu").supersubs({
                minWidth: 27,
                maxWidth: 27,
                extraWidth: 1
            }).superfish();
        });


    </script>
    <script type="text/javascript">

        function GetClock() {
            d = new Date();
            nday = d.getDay();
            nmonth = d.getMonth();
            ndate = d.getDate();
            nyear = d.getYear();
            nhour = d.getHours();
            nmin = d.getMinutes();
            if (nyear < 1000) nyear = nyear + 1900;

            if (nhour == 0) {
                ap = " AM";
                nhour = 12;
            }
            else if (nhour <= 11) {
                ap = " AM";
            }
            else if (nhour == 12) {
                ap = " PM";
            }
            else if (nhour >= 13) {
                ap = " PM";
                nhour -= 12;
            }

            if (nmin <= 9) {
                nmin = "0" + nmin;
            }

            document.getElementById('clockbox').innerHTML = "" + (nmonth + 1) + "/" + ndate + "/" + nyear + " " + nhour + ":" + nmin + ap + "";
            setTimeout("GetClock()", 1000);
        }
        window.onload = GetClock;
    </script>
    <script type="text/javascript" language="javascript">

        function GoBack() {
            window.history.forward();
        }
    </script>
    <script type="text/javascript" language="javascript">
        function StringTrim(x) {
            return x.replace(/^\s+|\s+$/gm, '');
        }
    </script>
    <link href="/stylesheet/style2.css" type="text/css" rel="stylesheet"/>

    <jsp:include page="/WEB-INF/jsp/inc/scripts.jsp"/>
</head>