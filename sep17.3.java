B. Knife's Pill Farm
time limit per test1.5 seconds
memory limit per test256 megabytes

Mr. Knife has drafted n
 absurd posts for a channel on a chat platform. His goal is to farm pill emoji reactions. Unfortunately, the channel's pill-farming bot uses an unnecessarily elaborate scoring rule.

The drafts have absurdity ratings a1,a2,…,an
, which may be negative. Mr. Knife must publish exactly m
 drafts in their original order. Their ratings form a subsequence∗
 b
 of a
 with length m
.

His pill score starts at 0
. When he publishes the i
-th chosen draft, the bot changes his score by i⋅(bi−bi−1)
, where b0=0
. A negative change deducts points, and the score is allowed to become negative. Thus, his final pill score is
∑i=1mi⋅(bi−bi−1).

What is the maximum pill score Mr. Knife can obtain by choosing which drafts to publish?

∗
A sequence a
 is a subsequence of a sequence b
 if a
 can be obtained from b
 by the deletion of several (possibly, zero or all) elements from arbitrary positions.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤104
). The description of the test cases follows.

The first line of each test case contains two integers n
 and m
 (1≤m≤n≤2⋅105
) — the number of drafts and the number of posts Mr. Knife must publish.

The second line contains n
 integers a1,a2,…,an
 (−107≤ai≤107
) — the absurdity ratings of the drafts.

It is guaranteed that the sum of n
 over all test cases does not exceed 2⋅105
.

Output
For each test case, print one integer — the maximum pill score Mr. Knife can obtain by publishing exactly m
 drafts in their original order.
