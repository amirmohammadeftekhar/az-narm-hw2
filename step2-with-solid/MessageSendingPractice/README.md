# تغییرات انجام شده برای پیاده‌سازی پیام تلگرام

## جدول تغییرات

| ردیف | محل اعمال تغییرات | عنوان تغییر | شرح تغییر |
|------|-------------------|-------------|------------|
| 1 | `src/edu/sharif/selab/models/TelegramMessage.java` | افزودن کلاس جدید | ایجاد کلاس TelegramMessage که از Message ارث‌بری می‌کند |
| 2 | `src/edu/sharif/selab/services/TelegramMessageService.java` | افزودن کلاس جدید | ایجاد کلاس TelegramMessageService که از MessageService ارث‌بری می‌کند |
| 3 | `src/Main.java` | افزودن import | اضافه کردن import برای TelegramMessage و TelegramMessageService |
| 4 | `src/Main.java` | تغییر در منو | افزودن گزینه جدید (3) برای پیام‌های تلگرام در منوی اصلی |
| 5 | `src/Main.java` | تغییر در switch | افزودن case 3 برای ایجاد و تنظیم پیام تلگرام |
| 6 | `src/Main.java` | تغییر در مدیریت پیام | افزودن بلوک else-if برای ارسال پیام تلگرام |
| 7 | `src/Main.java` | اصلاح متن راهنما | تغییر "phone" به "email" در متن راهنمای پیام ایمیل |

## تعداد کل تغییرات
- کلاس‌های جدید اضافه شده: 2
- فایل‌های تغییر یافته: 1
- تعداد کل تغییرات در Main.java: 5 