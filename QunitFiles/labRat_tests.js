test("8-Bit Lab Rat Qunit tests", function() {
    var calcChecksum = function(s) {
        var i;
        var chk = 0x12345678;

        for (i = 0; i < s.length; i++) {
            chk += (s.charCodeAt(i) * (i + 1));
        }
        return chk;
    };

    window.name = 0;
    deepEqual(calcChecksum(fetchNextQuote()), 305835575, "quote #1 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305655846, "quote #2 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305590524, "quote #3 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305587836, "quote #4 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305596137, "quote #5 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305947017, "quote #6 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 306138716, "quote #7 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305533906, "quote #8 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305662882, "quote #9 checksum");

    deepEqual(calcChecksum(fetchNextQuote()), 305684770, "quote #10 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305638634, "quote #11 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305657275, "quote #12 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305548355, "quote #13 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305707586, "quote #14 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305676676, "quote #15 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305575061, "quote #16 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305459210, "quote #17 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305589677, "quote #18 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305517959, "quote #19 checksum");

    deepEqual(calcChecksum(fetchNextQuote()), 305752497, "quote #20 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305799549, "quote #21 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305731298, "quote #22 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305757911, "quote #23 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305470723, "quote #24 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305908604, "quote #25 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 306146536, "quote #26 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305697198, "quote #27 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305704246, "quote #28 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305632183, "quote #29 checksum");

    deepEqual(calcChecksum(fetchNextQuote()), 305544406, "quote #30 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305536634, "quote #31 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305642460, "quote #32 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305483121, "quote #33 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305690435, "quote #34 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305575640, "quote #35 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305699599, "quote #36 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305840783, "quote #37 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305616523, "quote #38 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 306204487, "quote #39 checksum");

    deepEqual(calcChecksum(fetchNextQuote()), 305739284, "quote #40 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305533007, "quote #41 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305495272, "quote #42 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305823883, "quote #43 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305642424, "quote #44 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305632357, "quote #45 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305715590, "quote #46 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305659722, "quote #47 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305603854, "quote #48 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305718363, "quote #49 checksum");

    deepEqual(calcChecksum(fetchNextQuote()), 305463151, "quote #50 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305835575, "quote #51 checksum");
    deepEqual(calcChecksum(fetchNextQuote()), 305655846, "quote #52 checksum");
    } 
);
