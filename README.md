SmartSpenda – Personal Budget Tracker
Spend Smarter, Live Better

SmartSpenda is a full-featured Android personal budget tracking application designed to help users take control of their finances, set meaningful spending goals, and build better money habits — all in a fun, engaging way.

📖 Table of Contents
Overview
Key Features
Screenshots
Tech Stack
Architecture
Getting Started
Installation & Setup
How to Use
Project Structure
Testing
APK Download
Team
License
Acknowledgements


Overview
Managing personal finances is often seen as stressful or tedious. SmartSpenda transforms budget tracking into an engaging and rewarding experience through beautiful design, real‑time insights, and gamification elements.

The app is built for the South African market (ZAR currency) and works entirely offline using a local Room database – no internet connection or bank login required. It respects user privacy while delivering powerful budgeting tools.

This project was developed as a Portfolio of Evidence (POE) for the module OPSC6311 at [insert your institution]. It fulfills all requirements for Part 2 (App Prototype Development) and final POE submission.

✨ Key Features
Core Functionality (All Implemented)
🔐 User Authentication – Register and login with secure SHA‑256 password hashing.

📂 Expense Categories – Create, edit, delete custom categories (e.g., Groceries, Transport, Entertainment).

➕ Add Expense – Specify amount, date, start time, end time, description, category, and optionally attach a receipt photo.

💰 Budget Goals – Set both a monthly maximum budget and a monthly minimum spending goal (total and per category).

📋 Expense History – View all expenses with powerful filtering: Today, This Week, This Month, or any custom date range.

🖼️ Receipt Viewer – Tap any expense to view the attached receipt photo full‑screen.

📊 Category Spending Summary – For any selected period, see total money spent per category.

💾 Local Database – All data stored offline using Room (SQLite) – no cloud, no privacy concerns.

📈 Spending Graph – Visual daily spending trends (final POE) using MPAndroidChart.

🎯 Progress Dashboard – Real‑time overview of budget usage, remaining amount, and smart tips.

🏆 Gamification – Earn points and unlock tiers (Bronze, Silver, Gold, Platinum) based on number of expenses logged.

🌙 Dark Mode – Toggle between light and dark themes.

Additional Professional Touches
Material Design 3 – Modern UI with rounded cards, smooth animations, and adaptive layouts.

Custom Adaptive Icon – Professional SVG logo (piggy bank + rising graph + Rand coin) that adapts to any device shape.

Bottom Navigation – Quick access to Home, History, Budget, Insights, and Profile.

Search & Filter – Real‑time search across expense descriptions and categories.

Date & Time Pickers – Intuitive selection of date and start/end times.

Floating Action Button – Quick expense entry from any screen.

Responsive Layouts – Works on phones and tablets.

📸 Screenshots

See the uploaded folder 
SmartSpenda App UI

🛠️ Tech Stack
Category	Technologies
Language	Kotlin 2.0.21
UI	XML layouts, Material Design 3, ViewBinding, ConstraintLayout
Database	Room 2.8.4 with KSP (Kotlin Symbol Processing) instead of kapt
Architecture	MVVM with LiveData and coroutines
Image Loading	Glide 4.16.0
Charts	MPAndroidChart v3.1.0
Navigation	Android Navigation Component
Minimum SDK	API 24 (Android 7.0)
Target SDK	API 34 (Android 14)
Build Tool	Gradle (Kotlin DSL)
🏗️ Architecture
SmartSpenda follows the Model-View-ViewModel (MVVM) pattern:

Model – Room entities and DAOs (data layer)

View – Activities and Fragments (UI layer)

ViewModel – (planned for final version) Currently using direct coroutine calls from fragments for simplicity, but structured for easy migration.

Database – Single source of truth using Room. All operations are suspended and run on background threads using lifecycleScope.launch.

🚀 Getting Started
Prerequisites
Android Studio (Ladybug | 2024.1.1 or later)

JDK 11 or higher

Android SDK with API level 34

Git (optional, for cloning)

Clone the Repository
bash
git clone https://github.com/yourusername/SmartSpenda.git
cd SmartSpenda
Open in Android Studio
Launch Android Studio.

Select Open an existing project.

Navigate to the cloned folder and select it.

Wait for Gradle sync to complete.

Build and Run
Connect an Android device with USB debugging enabled, or

Start a virtual device from the AVD Manager.

Click the Run button (green triangle) or press Shift + F10.

The app will install and launch automatically.

📦 Installation & Setup
Direct APK Installation (No Android Studio needed)
If you just want to try the app:

Download the latest APK from the Releases section.

On your Android device, enable Install from unknown sources (Settings → Security → Unknown sources).

Open the APK file and tap Install.

Setting Up for Development (Android Studio)
Ensure the correct SDK and build tools are installed via SDK Manager.

The project uses KSP instead of kapt – no extra configuration needed.

If you encounter any build errors, try:

File → Invalidate Caches / Restart

Build → Clean Project then Rebuild Project

📱 How to Use
First Time
Open the app → You’ll see the Login screen.

Tap Register – enter your full name, email, and password (minimum 6 characters).

After successful registration, log in with your credentials.

Main Dashboard
Once logged in, you’ll see the Dashboard:

Total spent this month

Budget usage progress bar

Remaining amount

Smart tip based on your spending

Recent transactions

Adding an Expense
Tap the Floating Action Button (FAB) on the History screen, or navigate to History → FAB.

Enter amount, select category, pick date and start/end times, add description.

Optionally take a photo (camera) or choose from gallery as a receipt.

Tap Save Expense – it will appear in your history.

Managing Budgets
Go to Budget tab.

Set Total Monthly Budget (max) and Minimum Spend Goal.

Tap Save.

To set per‑category budgets, scroll down, tap + Add, select a category, and enter its max/min.

The progress bars show how close you are to each limit.

Viewing Expense History & Receipts
History tab shows all expenses for the selected period (Today, This Week, This Month, or custom).

Use the search bar to filter by description.

Tap any expense – if it has a receipt photo, a full‑screen dialog will show it.

Category Spending Summary
Go to Profile → Category Summary (or use the bottom navigation if added).

Select a period (Today/Week/Month/Custom) to see total spent per category.

AI Insights (Graph)
AI Insights tab (final POE) displays a 7‑day spending pattern graph using MPAndroidChart.

Profile & Settings
View your user info, join date, and gamification tier.

Manage Categories – add, edit, or delete expense categories.

Toggle Face ID, Notifications, and Dark Mode (switches work as placeholders).

Logout clears your session and returns to the login screen.

📂 Project Structure
text
SmartSpenda/
├── app/
│   ├── src/main/java/com/example/smartspenda/
│   │   ├── adapters/               # RecyclerView adapters
│   │   │   ├── CategoryAdapter.kt
│   │   │   ├── CategoryBudgetAdapter.kt
│   │   │   ├── CategoryTotalAdapter.kt
│   │   │   ├── ExpenseAdapter.kt
│   │   │   └── RecentExpenseAdapter.kt
│   │   ├── data/                   # Data layer
│   │   │   ├── entities/           # Room entities (User, Category, Expense, Budget)
│   │   │   └── database/           # Room database, DAOs, Converters
│   │   ├── ui/                     # UI layer (Activities & Fragments)
│   │   │   ├── auth/               # LoginActivity, RegisterActivity
│   │   │   ├── add_expense/        # AddExpenseActivity
│   │   │   ├── budget/             # BudgetFragment
│   │   │   ├── categories/         # ManageCategoriesActivity
│   │   │   ├── dashboard/          # DashboardFragment
│   │   │   ├── history/            # HistoryFragment
│   │   │   ├── insights/           # InsightsFragment (graph)
│   │   │   ├── profile/            # ProfileFragment
│   │   │   └── summary/            # CategorySummaryFragment
│   │   └── utils/                  # Helper classes
│   │       ├── DateHelper.kt
│   │       └── SecurityHelper.kt
│   └── src/main/res/               # Resources
│       ├── drawable/               # Icons, vector drawables, adaptive icon assets
│       ├── layout/                 # All XML layouts
│       ├── menu/                   # Bottom navigation menu
│       ├── navigation/             # nav_graph.xml
│       ├── values/                 # colors, strings, dimens, arrays, themes
│       └── xml/                    # file_paths.xml for FileProvider
├── build.gradle.kts                # Project-level build
├── settings.gradle.kts
├── gradle.properties
├── gradlew / gradlew.bat
└── README.md
🧪 Testing
Run Unit Tests
bash
./gradlew test
Run Instrumented Tests (Android device/emulator)
bash
./gradlew connectedAndroidTest
The project currently includes minimal tests, but you can add JUnit tests for utility classes (e.g., DateHelper, SecurityHelper).

📦 APK Download
You can download the latest release APK from the Releases page.

To build your own APK:

bash
./gradlew assembleRelease
The signed APK will be at:

text
app/build/outputs/apk/release/app-release.apk
Note: For release builds, you need to generate a signing key. For submission, you can use the debug APK or create a signed APK following Android documentation.

👥 Team
Name	Student ID	Role
Mufhumudzi Rasilingwana	St10441516	Research (analysed Zaka Manager, Vault22, Goodbudget)
Oluga Neluvhalani	St10443034	Planning, Development, Git management
Luthando Princess Mndawe	St10446457	UI/UX Design (all mockups, navigation flow)
📄 License
This project is developed solely for educational purposes as part of a Portfolio of Evidence (POE) for the module OPSC6311 at [Your Institution]. All rights reserved. Unauthorised copying, distribution, or use of this code is prohibited without prior written consent from the authors.

🙏 Acknowledgements
Google – Android documentation and libraries

Material Design 3 – UI components and design guidelines

Room Persistence Library

MPAndroidChart – Beautiful charting library

Glide – Image loading and caching

Kotlin Coroutines

Inkscape – Logo design

All South African budgeting apps (Zaka Manager, Vault22, Goodbudget) that inspired this work

📬 Contact
For questions or feedback regarding this POE submission, please contact your module lecturer or the team via the institutional portal.

Made with ❤️ for the Personal Budget Tracker – OPSC6311 POE

SmartSpenda – Spend Smarter, Live Better
