\# PRD



\## 1. Overview

\*\*Limen\*\* is a campus pre-order and pickup food application built with Kotlin Multiplatform.



\- \*\*Buyer client:\*\* Android app

\- \*\*Shop counter client:\*\* Windows Desktop app

\- \*\*Backend:\*\* Separate Ktor server (to be added in a later phase)



\## 2. Core Principles

\- \*\*Server-authoritative money and timing:\*\* The backend owns all monetary calculations, time windows, and state transitions.

\- \*\*Integer-paise money:\*\* All monetary values are represented as integer paise—no floating-point types (`Float`/`Double`) anywhere.

\- \*\*Three separate state machines:\*\* Payment state, order state, and settlement state are tracked independently and never conflated.

\- \*\*Honest simulated payment verification (MVP):\*\* Android initiates a real `upi://pay` intent handoff, while verification is explicitly \*\*SIMULATED\*\* and clearly labeled. The backend—never the client—decides when a payment becomes `VERIFIED`.



\## 3. Core End-to-End Loop (MVP)

1\. Buyer browses nearby shops.

2\. Buyer selects menu items into a single-shop cart and places an order.

3\. Shop approves or rejects the order within a server-enforced time window.

4\. On approval, buyer pays via Android UPI intent (`upi://pay`), followed by clearly labeled simulated verification decided by the backend (`VERIFIED`).

5\. Shop prepares the order and marks it ready.

6\. Buyer picks up the order using a 4-digit OTP entered by the shop to close the order.

7\. Paid/completed orders appear in Order History. Orders with expired approval or payment windows move to a separate \*\*Timed Out\*\* list with one-tap re-order.



\## 4. Buyer Features (Android)

\- \*\*Authentication:\*\* Email and password sign-in.

\- \*\*Location:\*\* Location permission request with manual location fallback if denied.

\- \*\*Nearby shop discovery:\*\*

&#x20; - Adjustable search radius (default: \*\*500 m\*\*).

&#x20; - Each shop displays: status tag (\*\*Accepting\*\* / \*\*Rush\*\* / \*\*Not Accepting\*\*), average prep time, and distance.

&#x20; - Sort options: \*\*Distance\*\* (default) or \*\*Alphabetical\*\*.

&#x20; - Filter: hide \*\*Not Accepting\*\* shops by default.

\- \*\*Shop detail \& menu:\*\* View shop info and menu items (name, price, photo).

\- \*\*Cart:\*\* Single-shop cart only.

\- \*\*Order placement \& payment:\*\*

&#x20; - Place order and wait for shop approval within the time window.

&#x20; - Pay via Android UPI intent (`upi://pay`) with clearly labeled simulated verification controlled by the backend.

\- \*\*Order tracking:\*\* Live status progression: \*\*Approved → Paid → Preparing → Ready → Picked Up\*\*.

\- \*\*Pickup OTP:\*\* Display the 4-digit OTP to the buyer when ready for pickup.

\- \*\*History \& Timed Out lists:\*\*

&#x20; - \*\*Order History:\*\* Paid orders only.

&#x20; - \*\*Timed Out list:\*\* Separate list for orders that expired during approval or payment, with one-tap re-order.



\## 5. Shop Counter Features (Windows Desktop)

\- \*\*Authentication:\*\* Shop account sign-in.

\- \*\*Shop profile:\*\* Manage basic shop info and location.

\- \*\*Menu management:\*\* Manual menu item upload (name, price, photo).

\- \*\*Live status toggle:\*\* Switch shop status between \*\*Accepting\*\*, \*\*Paused\*\*, and \*\*Rush\*\*.

\- \*\*Order queue:\*\*

&#x20; - View incoming orders with an audible and visual alert on new orders.

&#x20; - \*\*Approve\*\* or \*\*Reject\*\* incoming orders within the approval time window.

\- \*\*Fulfillment \& pickup:\*\*

&#x20; - \*\*Mark Prepared\*\* action when food is ready for pickup.

&#x20; - \*\*4-digit OTP entry\*\* at pickup to verify handover and close the order.

\- \*\*Order history:\*\* Basic list of past shop orders.

\- \*\*Payment screen placeholder:\*\* If a payment screen is ever reached on Windows, display: \*"Payments are currently supported on the Android app only"\*.



\## 6. Out of Scope for MVP

\- Reviews and ratings

\- Scheduled break-slot booking

\- Partial item rejection / substitution

\- Dine-in vs. takeaway toggle

\- Live queue token board

\- In-app wallet

\- Real payment gateway integration

\- Multi-shop cart

\- AI menu parsing

\- Admin panel

\- Seller approval workflow

