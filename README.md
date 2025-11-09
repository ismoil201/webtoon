# 🌐 Webtoon App (Naver Clone)

An Android **WebView-based Webtoon Reader** built with Kotlin and `ViewPager2`.  
Each tab remembers your **last visited page**, and offers seamless navigation between different webtoon categories.

---

## 🎥 Preview & Screenshots

<p align="center">
  <video src="https://github.com/user-attachments/assets/dfbba6ce-39aa-47b9-bb49-43f0326a266a"
         width="30%" autoplay loop muted></video>
  <img src="./screen1.png" width="30%" />
</p>

---

## 🧩 Key Features

- 📖 **In-App WebView Reader** for Naver Webtoons
- 🧠 Saves **last visited page** per tab
- 🔄 **Swipe navigation** with `ViewPager2`
- ⏳ **ProgressBar** loader
- 🧱 **Custom WebViewClient** to control URL loading
- 🪄 Supports in-app back navigation

---

## ⚙️ Technologies Used

| Component | Purpose |
|------------|----------|
| **Kotlin** | Main programming language |
| **WebView + WebViewClient** | Handles webtoon loading & logic |
| **SharedPreferences** | Stores tab history |
| **ViewPager2 + FragmentStateAdapter** | Manages tab views |
| **ProgressBar & Toast** | UI feedback & user interaction |

---

## 🚀 How to Run

1. Clone the project:
   ```bash
   git clone https://github.com/ismoil201/webtoon.git
