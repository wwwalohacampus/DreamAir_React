import React from 'react'

const TicketInfo = ({ticketNo, viewTicketDetail}) => {

  return (
    <div className="container p-4">
      <h1 className="text-center my-3">탑승권 조회</h1>

      <div className="img_container text-center">
        <img src="/img/ticket_page_ticket.png" alt="ticket_page_ticket.png" style={{ width: '50px', height: '50px' }} />
      </div>

      <h3>• 티켓 정보</h3>

      <table className="table table-striped table-hover table-bordered text-center align-middle">
        <thead>
          <tr className="table-primary">
            <th>탑승권 번호</th>
            <th>출발지</th>
            <th>도착지</th>
            <th>출발일</th>
            <th>선택 좌석</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td align='center'>{viewTicketDetail[0]?.ticketNo}</td>
            <td align='center'>{viewTicketDetail[0]?.departure}</td>
            <td align='center'>{viewTicketDetail[0]?.destination}</td>
            <td align='center'>{viewTicketDetail[0]?.departureDate}</td>
            <td align='center'>{viewTicketDetail[0]?.seatNo}</td>
          </tr>
        </tbody>
      </table>

      <br/><br/><br/>

      <h3>• 예매자 정보</h3>

      <table className="table table-striped table-hover table-bordered text-center align-middle">
        <thead>
          <tr className="table-primary">
            <th>예매자 명</th>
            <th>핸드폰 번호</th>
            <th>이메일</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td align='center'></td>
            <td align='center'></td>
            <td align='center'></td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default TicketInfo