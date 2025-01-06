# IdeaSphere API Documentation

**IdeaSphere System Description**

IdeaSphere is a dedicated platform that empowers individuals to showcase their creativity and innovation through organizing and participating in competitions across various fields. Organizers can be individuals or companies.

### Features

- **Competition Creation**: Enables organizers to create and manage competitions designed to meet their goals and requirements.
- **Submission Management**: Allows participants to submit their work easily, and organizers to review and evaluate entries.
- **Voting System**: Provides a fair and clear way to determine winners through public votes or organizer selection.
- **Notifications**: Keeps users informed with updates on deadlines, announcements, and competition results.
- **Diverse Categories**: Supports a wide range of competition types to suit different skills and interests.

---

**المقدمة**

فضاء الحلول هي منصة مخصصة تتيح للأفراد استعراض إبداعاتهم وابتكاراتهم من خلال تنظيم والمشاركة في مسابقات في مختلف المجالات. يمكن أن يكون المنظمون أفرادًا أو شركات.

### الميزات

- **إنشاء المسابقات**: تتيح للمنظمين والافراد إنشاء وإدارة مسابقات مصممة لتتناسب مع أهدافهم واحتياجاتهم.
- **إدارة المشاركات**: يمكن للمشاركين تقديم أعمالهم بسهولة، وللمنظمين مراجعة وتقييم المشاركات.
- **نظام التصويت**: يوفر طريقة عادلة وواضحة لتحديد الفائزين من خلال تصويت الجمهور أو اختيار المنظم.
- **الإشعارات**: تبقي المستخدمين على اطلاع بآخر التحديثات والمواعيد النهائية وإعلانات النتائج.
- **فئات متنوعة**: تدعم مجموعة واسعة من أنواع المسابقات لتلبي مختلف المهارات والاهتمامات.
  ---
### Links

- [Figma Design](https://www.figma.com/proto/oUBCUch383eDZlzbEHI1jv/IdeaSphere?node-id=61-497&p=f&t=1zzA4JYAwr813AdI-1&scaling=contain&content-scaling=fixed&page-id=0%3A1)
- [Presentation](https://www.canva.com/design/DAGbau1CiMA/fg470odHkUVnt0vgD1Unmg/edit)
- [PostMan API Documentation](https://documenter.getpostman.com/view/39709949/2sAYJAcwWX)
- 
  ---

## Class Diagram

![Class Diagram](https://cdn.discordapp.com/attachments/1321830373256335403/1325847348890566749/IdeaSphereClassDiagram.drawio.png?ex=677d4711&is=677bf591&hm=544b66b3840b4305752da97ce688d9c900d7666a08bf0c9d47adc8376e722fe1&)

## Use Case Diagram

![Use Case Diagram](https://cdn.discordapp.com/attachments/1321830373256335403/1325964561186164766/ideaSphereUseCase.drawio.png?ex=677db43a&is=677c62ba&hm=db0d9c750d1284664d39951e937a190b0a289b3b464040db2fb2f33d58abb08a&)

---


## Summary

- **Total Endpoints**: 30
- **Controllers**: 7

---

## Endpoints by Controller

### IndividualOrganizerController

1. **POST** `/individual-organizer/register` - Register a new individual organizer.
2. **GET** `/individual-organizer/get-profile` - Get the profile of the authenticated individual organizer.
3. **PUT** `/individual-organizer/update` - Update the profile of the authenticated individual organizer.
4. **POST** `/individual-organizer/send-inquiry` - Send an inquiry to the support team with a subject and message body.
   - **Example URL**: `POST http://localhost:8080/api/v1/individual-organizer/send-inquiry?subject=sign up page not working&text=sign up page not working, please fix it as soon as possible`

**Total**: 4 endpoints

### IndividualCompetitionController

1. **GET** `/individual-competition/get` - Get all individual competitions.
2. **GET** `/competition-payment/get-my-competition-payment-individual` - Get payment details for the authenticated individual.
3. **GET** `/individual-competition/get-my-competitions` - Get competitions for the authenticated individual.
4. **GET** `/individual-competition/get-competitions-by-status/Waiting payment` - Get individual competitions with a status of "Waiting payment".
5. **POST** `/individual-competition/add` - Create a new individual competition.
6. **POST** `/individual-competition/add-competition-payment` - Add competition payment details.
7. **PUT** `/individual-competition/update` - Update individual competition details.
8. **PUT** `/individual-competition/cancel-competition/1` - Cancel a competition with the given ID (e.g., "1").
9. **POST** `/individual-competition/extend-competition` - Extend the competition dates and participant numbers.

**Total**: 9 endpoints

### MonthlyDrawController

1. **GET** `/monthlyDraw/get-all-monthly-draws` - Get all monthly draws.
2. **GET** `/monthlyDraw/eligible` - Get eligible monthly draws.
3. **GET** `/monthlyDraw/findDrawsByName/Lucky Drawd` - Find monthly draws by name ("Lucky Drawd").
4. **GET** `/monthlyDraw/findDrawsByPrize/Gift Card` - Find monthly draws with "Gift Card" prize.
5. **POST** `/monthlyDraw/add` - Create a new monthly draw.
6. **PUT** `/monthlyDraw/update` - Update monthly draw details.

**Total**: 6 endpoints

### MonthlyDrawParticipantController

1. **POST** `/monthly-draw-participant/add/1` - Add a participant to the monthly draw with a specific ID (e.g., "1").
2. **GET** `/monthlyDrawParticipant/get` - Get details of all monthly draw participants.

**Total**: 2 endpoints

---

### SchedulerService

1. **Automatically scheduled task**: `checkLatePaymentCompetition` - Check and update competitions with late payments.
2. **Automatically scheduled task**: `assignMonthlyWinner` - Assign the winner for the monthly draw based on predefined criteria.

**Total**: 2 tasks (automated, not API endpoints)

---

**Grand Total (API Endpoints)**: 30
- **Total Endpoints**: 30
- **Controllers**: 7
