import axios from "axios";

// 회원 정보 조회 - id
export const selectById = (userId) => axios.get(`/user/${userId}`)

// 회원 정보 수정
export const update 
             = (userId, userPw, name, phone, email, address) => 
             axios.put("/user", {userId, userPw, name, phone, email, address})

// 마일리지 조회
export const selectMileage = (userId) => axios.get(`/user/${userId}`)

// 회원 탈퇴
export const deleteAccount = (userId) => axios.delete(`/user/${userId}`)

// 예매 내역 조회 - 회원
export const selectBookingListByUser = (userId) => axios.get(`/user/bookingList/${userId}`)

// 티켓 상세 조회
// export const viewTicket = (ticketNo, userId) => axios.get(`/user/booking/ticketInfo/${ticketNo}`, {ticketNo, userId})
export const viewTicket = (ticketNo, userId) => axios.get(`/user/booking/ticketInfo/${ticketNo}?userId=${userId}`);