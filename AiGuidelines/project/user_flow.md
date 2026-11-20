\# User Flow



\## 1. End-to-End Core Loop

1\. \*\*Buyer (Android):\*\* Signs in, sets location, browses nearby shops, adds items from one shop to cart, and places an order.

2\. \*\*Shop (Windows Desktop):\*\* Receives audible/visual new-order alert in the order queue and chooses \*\*Approve\*\* or \*\*Reject\*\* within the approval window.

3\. \*\*Buyer (Android):\*\* Once approved, triggers payment via Android UPI intent (`upi://pay`) within the payment window.

4\. \*\*Backend:\*\* Processes payment report and transitions payment to `VERIFIED` via clearly labeled \*\*SIMULATED\*\* verification (client never decides `VERIFIED`).

5\. \*\*Shop (Windows Desktop):\*\* Prepares the verified paid order and clicks \*\*Mark Prepared\*\*.

6\. \*\*Pickup Handover:\*\* Buyer sees \*\*Ready\*\* status and their 4-digit OTP; buyer shares the OTP at the counter; shop enters the 4-digit OTP to close the order (\*\*Picked Up\*\*).

7\. \*\*Post-Order:\*\* Paid order is recorded in both Buyer and Shop Order History.



\## 2. Buyer Flow (Android)

1\. \*\*Sign In:\*\* Enter email and password to authenticate.

2\. \*\*Location Setup:\*\*

&#x20;  - Grant location permission, \*\*or\*\*

&#x20;  - If denied, enter location manually as a fallback.

3\. \*\*Browse Nearby Shops:\*\*

&#x20;  - View shops within the adjustable radius slider (default \*\*500 m\*\*).

&#x20;  - Default filter hides \*\*Not Accepting\*\* shops; default sort is \*\*Distance\*\* (can switch to \*\*Alphabetical\*\*).

&#x20;  - Inspect status tag (\*\*Accepting\*\* / \*\*Rush\*\* / \*\*Not Accepting\*\*), average prep time, and distance.

4\. \*\*Select Items:\*\* Open a shop detail screen, browse menu items (name, price, photo), and add items to the single-shop cart.

5\. \*\*Place Order:\*\* Submit cart and enter the approval-wait state.

6\. \*\*Pay (after Approval):\*\*

&#x20;  - Launch Android UPI intent (`upi://pay`).

&#x20;  - Observe clearly labeled simulated payment verification status until backend confirms `VERIFIED`.

7\. \*\*Track Order \& Pick Up:\*\*

&#x20;  - Follow order status: \*\*Approved → Paid → Preparing → Ready → Picked Up\*\*.

&#x20;  - Show the displayed 4-digit OTP at the counter to complete pickup.

8\. \*\*Review Past Orders:\*\*

&#x20;  - Open \*\*Order History\*\* for paid orders only.

&#x20;  - Open \*\*Timed Out\*\* for orders whose approval or payment window expired, and use \*\*one-tap re-order\*\* if desired.



\## 3. Shop Counter Flow (Windows Desktop)

1\. \*\*Sign In:\*\* Authenticate into the shop counter account.

2\. \*\*Setup \& Operations:\*\*

&#x20;  - Enter or update shop info and location.

&#x20;  - Manually upload/manage menu items (name, price, photo).

&#x20;  - Toggle live availability between \*\*Accepting\*\*, \*\*Paused\*\*, and \*\*Rush\*\*.

3\. \*\*Handle Incoming Orders:\*\*

&#x20;  - Receive audible and visual alert when a new order arrives in the queue.

&#x20;  - Click \*\*Approve\*\* or \*\*Reject\*\* before the approval time window expires.

4\. \*\*Prepare \& Hand Over:\*\*

&#x20;  - Prepare paid, backend-verified orders.

&#x20;  - Click \*\*Mark Prepared\*\* when ready for pickup.

&#x20;  - Enter the buyer's 4-digit OTP at pickup to close the order.

5\. \*\*Review History:\*\* View basic past shop order history.



\## 4. Timeout \& Platform Fallback Flows

\- \*\*Approval Timeout:\*\* If the shop does not approve within the time window, the backend expires the order; it moves to the buyer's \*\*Timed Out\*\* list (never Order History) with one-tap re-order.

\- \*\*Payment Timeout:\*\* If the buyer does not complete payment within the payment window, the backend expires the order; it moves to the buyer's \*\*Timed Out\*\* list with one-tap re-order.

\- \*\*Windows Payment Screen:\*\* If a payment screen is ever reached on Windows Desktop, display: \*"Payments are currently supported on the Android app only"\*.

