test("Xtreme Java Quiz Qunit tests", function() {

                var calcChecksum = function(s) {
                    var i;
                    var chk = 0x12345678;

                    for (i = 0; i < s.length; i++) {
                        chk += (s.charCodeAt(i) * (i + 1));
                    }
                    return chk;
                };

		deepEqual(xtremeJavaQuiz.stripFirstCR("foo bar\n dee"), "foo bar dee",
			 "strip single carriage return");
		deepEqual(xtremeJavaQuiz.stripFirstCR("foo bar\n\n"), "foo bar\n",
			 "strip first carriage return");

		deepEqual(xtremeJavaQuiz.stripAllCR("foo bar\n"), "foo bar",
			 "strip single carriage return");

		deepEqual(xtremeJavaQuiz.stripAllCR("foo bar\n\n dee"), "foo bar dee",
			 "strip both carriage returns");

        var str = xtremeJavaQuiz.fetchNextQuestion(1).toString();
		deepEqual(calcChecksum(str), 394867272, "q1 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(2).toString();
		deepEqual(calcChecksum(str), 388285247, "q2 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(3).toString();
		deepEqual(calcChecksum(str), 353586368, "q3 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(4).toString();
		deepEqual(calcChecksum(str), 408056593, "q4 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(5).toString();
		deepEqual(calcChecksum(str), 437992374, "q5 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(6).toString();
		deepEqual(calcChecksum(str), 366459551, "q6 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(7).toString();
		deepEqual(calcChecksum(str), 489944340, "q7 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(8).toString();
		deepEqual(calcChecksum(str), 355094658, "q8 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(9).toString();
		deepEqual(calcChecksum(str), 432569081, "q9 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(10).toString();
		deepEqual(calcChecksum(str), 482875596, "q10 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(11).toString();
		deepEqual(calcChecksum(str), 407562382, "q11 checksum");

                str = xtremeJavaQuiz.fetchNextQuestion(12).toString();
		deepEqual(calcChecksum(str), 591618789, "q12 checksum");
	} 
);
