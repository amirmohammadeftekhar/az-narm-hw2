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

  
# تحلیل اصول SOLID در پروژه 

## جدول تحلیل اصول SOLID (به جز اصل مسئولیت تکی)

| ردیف | اصل SOLID | تحقق/نقض | توضیحات |
|------|-----------|----------|---------|
| 1 | Open-Closed Principle | نقض | کلاس Main همواره باید برای افزودن هر نوع پیام جدید تغییر کند (همانطور که برای افزودن TelegramMessage تغییر کرد). بنابراین برای توسعه باز نیست و برای تغییر بسته نیست. |
| 2 | Open-Closed Principle | تحقق | کلاس‌های سرویس (SmsMessageService، EmailMessageService، TelegramMessageService) به صورت مستقل پیاده‌سازی شده‌اند و می‌توانند بدون تغییر در کلاس‌های دیگر توسعه یابند. |
| 3 | Liskov Substitution Principle | نقض | در کلاس TelegramMessageService متد sendEmailMessage پیاده‌سازی شده اما با خطای UnsupportedOperationException مواجه می‌شود که نقض اصل جایگزینی لیسکوف است. |
| 4 | Liskov Substitution Principle | تحقق | کلاس‌های سرویس از یک واسط مشترک (MessageService) ارث‌بری می‌کنند و می‌توانند در برخی موارد جایگزین یکدیگر شوند. |
| 5 | Interface Segregation Principle | نقض | واسط MessageService دارای متدهایی است که برخی از پیاده‌سازی‌ها به آن‌ها نیاز ندارند. برای مثال TelegramMessageService باید متد sendEmailMessage را پیاده‌سازی کند، در حالی که این متد برای آن معنادار نیست. |
| 6 | Interface Segregation Principle | تحقق | هر کلاس سرویس فقط مسئولیت ارسال یک نوع پیام را بر عهده دارد و از این نظر وظایف به خوبی تفکیک شده‌اند. |
| 7 | Dependency Inversion Principle | نقض | کلاس Main مستقیماً به پیاده‌سازی‌های خاص سرویس‌ها وابسته است (SmsMessageService، EmailMessageService، TelegramMessageService) به جای اینکه به انتزاع وابسته باشد. |
| 8 | Dependency Inversion Principle | تحقق | کلاس‌های سرویس به واسط MessageService وابسته هستند و از پیاده‌سازی‌های خاص مستقل هستند. | 
